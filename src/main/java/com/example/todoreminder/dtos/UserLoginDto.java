package com.example.todoreminder.dtos;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserLoginDto {

 private String email;
 private String password;
}


