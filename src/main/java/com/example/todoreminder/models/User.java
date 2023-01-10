package com.example.todoreminder.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid", nullable = false)
    private long userid;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "dateOfBirth", nullable = false)
    private LocalDate dateOfBirth;
    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "categoryid")
    private List<Category> category;

    @OneToMany(mappedBy = "taskid")
    private List<Task> task;
}
