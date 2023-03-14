package com.example.todoreminder.model.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String name;
    private String surname;
    private String email;
    private LocalDate dateOfBirth;
    private String password;
}
