package com.example.todoreminder.controllers;


import com.example.todoreminder.dtos.UserLoginDto;
import com.example.todoreminder.dtos.UserRegistrationDto;
import com.example.todoreminder.models.User;
import com.example.todoreminder.services.UserService;
import com.sun.net.httpserver.Authenticator;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegistrationDto registrationDto) {
        userService.register(registrationDto);
        return ResponseEntity.ok("User is registered!");

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDto userLoginDto) throws Exception{
        userService.login(userLoginDto);
        return ResponseEntity.ok("user is logged in");
    }


}
