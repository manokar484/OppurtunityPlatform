package com.example.NeedYou.Authentication.Repository;
import com.example.NeedYou.Authentication.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
    Optional<User> findByMobileNo(String mobileNo);

}
