package com.example.todoreminder.controllers;

import com.example.todoreminder.dtos.UserLoginDto;
import com.example.todoreminder.dtos.UserRegistrationDto;
import com.example.todoreminder.models.User;
import com.example.todoreminder.services.AuthService;
import com.example.todoreminder.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final AuthService authService;

    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserRegistrationDto registrationDto){

        return ResponseEntity.ok(authService.register(registrationDto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDto loginDto) throws Exception{
        return ResponseEntity.ok(authService.login(loginDto));
    }


}
