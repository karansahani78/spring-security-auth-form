package com.karan.Login.Form.Authentication.controller;

import com.karan.Login.Form.Authentication.model.User;
import com.karan.Login.Form.Authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping("/user")
    public List<User>findAllUser(){
        return userService.getAllUsers();
    }
}
