package com.example.todoreminder.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private long taskId;
    private String title;
    private boolean isCompleted;
    private LocalDate createdDate;
    private LocalTime createdTime;

}