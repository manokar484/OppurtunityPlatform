package com.example.NeedYou.Authentication.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "users")
@Getter
@Setter
public class User {

    @Id
    private String id;
    @NonNull
    private String name;

    @Indexed(unique = true)
    @NonNull
    private String email;

    @Indexed(unique = true)
    @NonNull
    private String mobileNo;
    @NonNull
    private String password;

    private Role role;

    private String otp;
    private LocalDateTime otpExpiry;
    private boolean verified = false;
}