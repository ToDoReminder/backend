package com.example.todoreminder.controllers;

import com.example.todoreminder.services.AuthService;
import com.example.todoreminder.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
  //  private final AuthService authService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


}
