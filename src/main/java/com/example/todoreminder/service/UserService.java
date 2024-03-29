package com.example.todoreminder.service;

import com.example.todoreminder.config.PasswordEncoder;
import com.example.todoreminder.entity.User;
import com.example.todoreminder.mapper.UserMapper;
import com.example.todoreminder.model.dto.UserDto;
import com.example.todoreminder.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;




    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(""));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByEmail(username);
    }

    public UserDto getUserbyId(Long id) {
      return userMapper.getUserDto(userRepository.findById(id).get());
    }

    public void deleteUser(Long id) {
        User user =userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }



}
