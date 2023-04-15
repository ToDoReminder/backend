package com.example.todoreminder.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "categories")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryid", nullable = false)
    private long categoryid;
    @Column(name = "title", nullable = false)
    private String title;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userid")
    private User user;
    @OneToMany(mappedBy = "category")
    private List<Task> task;
}
