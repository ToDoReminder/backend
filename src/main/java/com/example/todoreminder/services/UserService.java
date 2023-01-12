package com.example.todoreminder.services;

import com.example.todoreminder.config.security.PasswordEncoder;
import com.example.todoreminder.dtos.UserRegistrationDto;
import com.example.todoreminder.mappers.UserMapper;
import com.example.todoreminder.models.User;
import com.example.todoreminder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserMapper userMapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }





    public void register(UserRegistrationDto registrationDto){

     User user = new User();

     user.setName(registrationDto.getName());
     user.setSurname(registrationDto.getSurname());
     user.setEmail(registrationDto.getEmail());
     user.setDateOfBirth(registrationDto.getDateOfBirth());
     user.setPassword(passwordEncoder.bCryptPasswordEncoder().encode(registrationDto.getPassword()));

     userRepository.save(user);




    }
}
