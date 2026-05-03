package com.example.NeedYou.Authentication.Service;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Value("${twilio.phone-number}")
    private String twilioNumber;

    public void sendOtp(String mobileNo, String otp) {

        Message.creator(
                new PhoneNumber("+91" + mobileNo),  // receiver
                new PhoneNumber(twilioNumber),       // sender (Twilio number)
                "Your OTP is: " + otp
        ).create();
    }
}
