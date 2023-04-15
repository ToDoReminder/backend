package com.example.todoreminder.controller;

import com.example.todoreminder.entity.User;
import com.example.todoreminder.model.request.LoginRequest;
import com.example.todoreminder.model.request.RegisterRequest;
import com.example.todoreminder.service.AuthService;
import com.example.todoreminder.service.AuthorizationService;
import com.example.todoreminder.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final AuthService authService;

    private final AuthorizationService authorizationService;

    public AuthController(UserService userService, AuthService authService, AuthorizationService authorizationService) {
        this.userService = userService;
        this.authService = authService;
        this.authorizationService = authorizationService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) throws Exception{
        return ResponseEntity.ok(authService.login(request));
    }


}
