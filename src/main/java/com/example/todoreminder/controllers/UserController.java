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






}
