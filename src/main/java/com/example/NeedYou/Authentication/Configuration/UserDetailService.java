package com.example.NeedYou.Authentication.Configuration;

import com.example.NeedYou.Authentication.model.Role;
import com.example.NeedYou.Authentication.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {

    private User getCurrentUser() {

        Authentication authentication =
                SecurityContextHolder.getContext()
                        .getAuthentication();

        return (User) authentication.getPrincipal();
    }

    public String getName() {
        return getCurrentUser().getName();
    }

    public String getEmail() {
        return getCurrentUser().getEmail();
    }

    public Role getRole() {
        return getCurrentUser().getRole();
    }

    public String getId() {
        return getCurrentUser().getId();
    }

    public String getMobileNo() {
        return getCurrentUser().getMobileNo();
    }
}
