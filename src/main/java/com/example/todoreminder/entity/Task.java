package com.example.todoreminder.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
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
    private LocalDate updatedDate = null;
    private LocalTime updatedTime = null;
    @Column(name = "is_completed", nullable = false)
    private boolean isCompleted = false;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
