package com.example.todoreminder.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", nullable = false)
    private long userid;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(name = "user_surname", nullable = false)
    private String surname;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "date_of_birth", nullable = false)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDate dateOfBirth;
    @Column(name = "password", nullable = false)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @OneToMany(mappedBy = "categoryid")
    private List<Category> category;
    @OneToMany(mappedBy = "taskid")
    private List<Task> task;


}
