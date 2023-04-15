package com.example.todoreminder.mapper;

import com.example.todoreminder.entity.Category;
import com.example.todoreminder.entity.User;
import com.example.todoreminder.model.dto.CategoryDto;
import com.example.todoreminder.model.request.CategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMapper {
    public CategoryDto categoryDto(Category category) {
        return CategoryDto.builder()
                .categoryId(category.getCategoryid())
                .title(category.getTitle())
                .build();
    }

    public Category createCategory(User user, CategoryRequest categoryRequest) {
        return Category.builder()
                .title(categoryRequest.getTitle())
                .user(user)
                .build();
    }
}
