package com.example.todoreminder.services;

import com.example.todoreminder.repositories.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




public class AuthService {

    @Autowired
    UserRepository userRepository;






}
