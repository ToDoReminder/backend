package com.example.todoreminder.services;

import com.example.todoreminder.config.security.JwtTokenUtility;
import com.example.todoreminder.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@AllArgsConstructor
public class AuthorizationService {

    private final UserService userService;
    private final JwtTokenUtility jwtTokenUtility;

    public Long getUserIdFromHttpRequest(HttpServletRequest request) {
        return getUserFromHttpRequest(request).getUserid();
    }

    public User getUserFromHttpRequest(HttpServletRequest request) {
        final String token = request.getHeader("Authorization").substring(7);
        return userService.findByEmail(jwtTokenUtility.getUsernameFromToken(token));
    }
}
