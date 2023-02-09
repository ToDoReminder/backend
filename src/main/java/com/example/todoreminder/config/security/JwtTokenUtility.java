package com.example.todoreminder.config.security;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;



import java.io.Serializable;
import java.util.Date;


@Component
public class JwtTokenUtility implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;

    public static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60;
    public static final long JWT_TOKEN_VALIDITY_REMEMBER_ME = 24 * 60 * 60 * 7;





}
