package com.example.todoreminder.mapper;

import com.example.todoreminder.config.PasswordEncoder;
import com.example.todoreminder.entity.User;
import com.example.todoreminder.model.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;
    public User register(RegisterRequest request){
        return User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password(passwordEncoder.bCryptPasswordEncoder().encode(request.getPassword()))
                .dateOfBirth(request.getDateOfBirth())
                .build();

    }
}
