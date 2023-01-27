package com.example.todoreminder.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "taskid", nullable = false)
    private long taskid;
    @Column(name = "title", nullable = false)
    private String title;
    private LocalDate createdDate;
    private LocalTime createdTime;
    @Column(name = "is_completed", nullable = false)
    private boolean isCompleted;
    @OneToOne
    @JoinColumn(name = "categoryid")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;
}
