package com.example.NeedYou.Authentication.Service;

import com.example.NeedYou.Authentication.Repository.UserDetailsRepository;
import com.example.NeedYou.Authentication.Repository.UserRepository;
import com.example.NeedYou.Authentication.Security.JwtUtil;
import com.example.NeedYou.Authentication.model.Role;
import com.example.NeedYou.Authentication.model.User;
import com.example.NeedYou.Authentication.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SmsService smsService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public User register(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setVerified(false);
        User savedUser = userRepository.save(user);
        UserDetails details = new UserDetails();
        details.setUserId(savedUser.getId());
        details.setAverageRating(0);
        details.setTotalRatings(0);
        userDetailsRepository.save(details);
        return savedUser;
    }
    public String sendOtp(String  mobileNo) {
        User user = userRepository.findByMobileNo(mobileNo)
                .orElseThrow(() -> new RuntimeException("User Not Registered"));

        String otp = generateOtp();
        user.setOtp(otp);
        user.setOtpExpiry(LocalDateTime.now().plusMinutes(5));
        user.setVerified(false);
        userRepository.save(user);
        smsService.sendOtp(user.getMobileNo(), otp);

        return " OTP sent to mobile "+ user.getMobileNo();
    }
    public void clearAllUser() {
        userRepository.deleteAll();

    }
    public List<User> getAllUser() {
        userRepository.deleteAll();
        return userRepository.findAll();
    }

    public String login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 1. Check if user is verified (OTP completed)
        if (!user.isVerified()) {
            throw new RuntimeException("Please verify OTP before login");
        }

        // 2. Validate password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwtUtil.generateToken(user.getEmail());
    }
    public String verifyOtp(String mobileNo, String otp) {

        User user = userRepository.findByMobileNo(mobileNo)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (user.getOtpExpiry() == null || user.getOtpExpiry().isBefore(LocalDateTime.now())) {
            return "OTP expired. Please request a new one.";
        }
        if (user.getOtp().equals(otp)) {
            user.setVerified(true);
            user.setOtp(null);
            userRepository.save(user);
            return "Account verified successfully";
        }

        return "Invalid OTP";
    }
    private String generateOtp() {
        return String.valueOf((int)(Math.random() * 900000) + 100000);
    }
    public String sendLoginOtp(String mobileNo) {

        User user = userRepository.findByMobileNo(mobileNo)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String otp = generateOtp();

        user.setOtp(otp);
        user.setOtpExpiry(LocalDateTime.now().plusMinutes(5));

        userRepository.save(user);

        smsService.sendOtp(mobileNo, otp);

        return "OTP sent successfully";
    }
    public String verifyOtpLogin(String mobileNo, String otp) {

        User user = userRepository.findByMobileNo(mobileNo)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 1. Check expiry
        if (user.getOtpExpiry() == null ||
                user.getOtpExpiry().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("OTP expired");
        }

        // 2. Validate OTP
        if (!otp.equals(user.getOtp())) {
            throw new RuntimeException("Invalid OTP");
        }

        // 3. Clear OTP
        user.setOtp(null);
        user.setOtpExpiry(null);
        userRepository.save(user);

        // 4. Generate JWT (IMPORTANT)
        return jwtUtil.generateToken(user.getEmail());
    }
    public String forgotPassword(String identifier) {

        User user = findUser(identifier);

        String otp = generateOtp();

        user.setOtp(otp);
        user.setOtpExpiry(LocalDateTime.now().plusMinutes(5));

        userRepository.save(user);

        // ✅ Always send to mobile number
        smsService.sendOtp(user.getMobileNo(), otp);

        return "OTP sent to registered mobile number";
    }
    public User findUser(String identifier) {

        if (identifier.contains("@")) {
            return userRepository.findByEmail(identifier)
                    .orElseThrow(() -> new RuntimeException("User not found"));
        } else {
            return userRepository.findByMobileNo(identifier)
                    .orElseThrow(() -> new RuntimeException("User not found"));
        }
    }
    public String resetPassword(String identifier, String otp, String newPassword) {

        User user = findUser(identifier);

        // 1. Check expiry
        if (user.getOtpExpiry() == null ||
                user.getOtpExpiry().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("OTP expired");
        }

        // 2. Validate OTP
        if (!otp.equals(user.getOtp())) {
            throw new RuntimeException("Invalid OTP");
        }

        // 3. Update password
        user.setPassword(Objects.requireNonNull(passwordEncoder.encode(newPassword)));

        // 4. Clear OTP
        user.setOtp(null);
        user.setOtpExpiry(null);

        userRepository.save(user);

        return "Password reset successful";
    }
    public Map<String, Object> getUserProfile(String userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserDetails details = userDetailsRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Details not found"));

        Map<String, Object> response = new HashMap<>();
        response.put("user", user);
        response.put("details", details);

        return response;
    }
}
