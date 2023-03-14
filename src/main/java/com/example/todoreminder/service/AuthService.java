package com.example.todoreminder.service;

import com.example.todoreminder.config.PasswordEncoder;
import com.example.todoreminder.config.security.JwtTokenUtility;
import com.example.todoreminder.entity.User;
import com.example.todoreminder.mapper.UserMapper;
import com.example.todoreminder.model.request.LoginRequest;
import com.example.todoreminder.model.request.RegisterRequest;
import com.example.todoreminder.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {


    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtility jwtTokenUtility;
    private final UserService userService;
    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;



    public User register(RegisterRequest request) {

        User user = userMapper.register(request);
        userRepository.save(user);
        return user;
    }
    public String login(LoginRequest request) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        } catch (DisabledException e){
            throw new Exception("DisabledException");
        } catch (BadCredentialsException e){
            throw new Exception(e.getMessage());
        }
        return jwtTokenUtility.generateToken(userService.findByEmail(request.getEmail()));
    }
}
