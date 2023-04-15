package com.example.todoreminder.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private long categoryId;
    private String title;
}
