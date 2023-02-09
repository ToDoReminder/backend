package com.example.todoreminder.services;

import com.example.todoreminder.dtos.UserLoginDto;
import com.example.todoreminder.dtos.UserRegistrationDto;
import com.example.todoreminder.models.User;
import com.example.todoreminder.repositories.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;


@Service
public class UserService {


    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;



    public UserService(UserRepository userRepository, AuthenticationManager authenticationManager) {

        this.userRepository = userRepository;

        this.authenticationManager = authenticationManager;
    }

    public void findByEmail(String email) throws Exception {
        try{
             userRepository.findByEmail(email);
        } catch(Exception e){
            throw new Exception("User not found!");
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


    public void login(UserLoginDto userLoginDto) throws Exception{

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginDto.getEmail(), userLoginDto.getPassword()));
        } catch(DisabledException e){
            throw new Exception("Disabled Exception");
        } catch (BadCredentialsException e){
            throw new Exception("Bad Credentials");

        }
    }
}
