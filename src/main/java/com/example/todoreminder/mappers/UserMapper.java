package com.example.todoreminder.mappers;

import com.example.todoreminder.dtos.UserRegistrationDto;
import com.example.todoreminder.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userRegistration(UserRegistrationDto registrationDto);
}
