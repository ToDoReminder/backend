package com.example.todoreminder.services;

import com.example.todoreminder.config.PasswordEncoder;
import com.example.todoreminder.config.security.JwtTokenUtility;
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
public class AuthService {


    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtility jwtTokenUtility;
    private final UserService userService;

    private final PasswordEncoder passwordEncoder;





    public AuthService(UserRepository userRepository, AuthenticationManager authenticationManager, JwtTokenUtility jwtTokenUtility, UserService userService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtility = jwtTokenUtility;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(UserRegistrationDto registrationDto) {

        User user = new User();

        user.setName(registrationDto.getName());
        user.setSurname(registrationDto.getSurname());
        user.setEmail(registrationDto.getEmail());
        user.setDateOfBirth(registrationDto.getDateOfBirth());
        user.setPassword(passwordEncoder.bCryptPasswordEncoder().encode(registrationDto.getPassword()));

        userRepository.save(user);

        return user;


    }
    public String login(UserLoginDto loginDto) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        } catch (DisabledException e){
            throw new Exception("DisabledException");
        } catch (BadCredentialsException e){
            throw new Exception(e.getMessage());
        }
        return jwtTokenUtility.generateToken(userService.findByEmail(loginDto.getEmail()));
    }
}
