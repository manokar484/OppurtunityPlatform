package com.example.NeedYou.Authentication.Repository;

import com.example.NeedYou.Authentication.model.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserDetailsRepository extends MongoRepository<UserDetails, String> {
    Optional<UserDetails> findByUserId(String userId);
}