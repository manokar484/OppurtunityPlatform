package com.example.NeedYou.BookingManagement.Controllers;

import com.example.NeedYou.Authentication.Configuration.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingControllers {
    @Autowired
    private UserDetailService userDetailService;
    @GetMapping("/me")
    public String  me() {
       return  userDetailService.getEmail();

    }

}
