package com.example.todoreminder.services;

import com.example.todoreminder.dtos.UserLoginDto;
import com.example.todoreminder.dtos.UserRegistrationDto;
import com.example.todoreminder.models.User;
import com.example.todoreminder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;

    }

    public void findByEmail(String email) throws Exception {
        try{
             userRepository.findByEmail(email);
        } catch(Exception e){
            throw new Exception("User not found!");
        }
    }

    public void login(UserLoginDto userLoginDto) throws Exception{
        try {
            findByEmail(userLoginDto.getEmail());

        }
        catch(Exception e){
         throw new Exception("User cannot found in the database");
        }

    }





    public void register(UserRegistrationDto registrationDto) {

        User user = new User();

        user.setName(registrationDto.getName());
        user.setSurname(registrationDto.getSurname());
        user.setEmail(registrationDto.getEmail());
        user.setDateOfBirth(registrationDto.getDateOfBirth());
        user.setPassword(registrationDto.getPassword());

        userRepository.save(user);


    }
}
