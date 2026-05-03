package com.example.NeedYou.Authentication.Controllers;

import com.example.NeedYou.Authentication.Service.UserService;
import com.example.NeedYou.Authentication.model.LoginRequest;
import com.example.NeedYou.Authentication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/sendOtp")
    public ResponseEntity<?> sendOtp(@RequestParam String mobileNo) {
        return ResponseEntity.ok(userService.sendOtp(mobileNo));
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestParam String mobileNo,
                                       @RequestParam String otp) {
        return ResponseEntity.ok(userService.verifyOtp(mobileNo, otp));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request.getEmail(), request.getPassword()));
    }

    @PostMapping("/login-otp")
    public ResponseEntity<?> sendLoginOtp(@RequestParam String mobileNo) {
        return ResponseEntity.ok(userService.sendLoginOtp(mobileNo));
    }

    @PostMapping("/verify-login-otp")
    public ResponseEntity<?> verifyOtpLogin(@RequestParam String mobileNo,
                                            @RequestParam String otp) {
        return ResponseEntity.ok(userService.verifyOtpLogin(mobileNo, otp));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestParam String identifier) {
        return ResponseEntity.ok(userService.forgotPassword(identifier));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestParam String identifier,
                                           @RequestParam String otp,
                                           @RequestParam String newPassword) {
        return ResponseEntity.ok(userService.resetPassword(identifier, otp, newPassword));
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUser() {

        return ResponseEntity.ok(userService.getAllUser());
    }

    @DeleteMapping("/clearAllUser")
    public ResponseEntity<?> clearAllUser() {
        userService.clearAllUser();
        return ResponseEntity.ok("All users deleted successfully");
    }

}
//Logout,Social Login,Account Lockout,Password Strength Validation,Rate Limiting,Profile Management,Session Management
