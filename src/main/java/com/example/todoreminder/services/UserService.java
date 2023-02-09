package com.example.todoreminder.services;

import com.example.todoreminder.config.security.PasswordEncoder;
import com.example.todoreminder.dtos.UserLoginDto;
import com.example.todoreminder.dtos.UserRegistrationDto;
import com.example.todoreminder.models.User;
import com.example.todoreminder.repositories.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;



    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;

        this.passwordEncoder = passwordEncoder;
    }

    public User findByEmail(String email){

        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(""));

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


    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return findByEmail(s);
    }
}
