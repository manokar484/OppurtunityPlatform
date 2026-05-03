package com.example.NeedYou.Authentication.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Getter
@Setter
@Document(collection = "user_details")
public class UserDetails {

    @Id
    private String id;

    private String userId;  // 🔗 reference to User

    private String location;

    private List<String> skills;

    private double averageRating;
    private int totalRatings;
}
