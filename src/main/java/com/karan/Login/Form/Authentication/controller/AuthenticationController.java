package com.karan.Login.Form.Authentication.controller;

import com.karan.Login.Form.Authentication.model.User;
import com.karan.Login.Form.Authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @GetMapping("/welcome")
    public String getWelcome() {
        return "Welcome";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
}