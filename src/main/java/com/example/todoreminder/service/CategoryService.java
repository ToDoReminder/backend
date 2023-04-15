package com.example.todoreminder.service;

import com.example.todoreminder.entity.Category;
import com.example.todoreminder.entity.User;
import com.example.todoreminder.mapper.CategoryMapper;
import com.example.todoreminder.model.dto.CategoryDto;
import com.example.todoreminder.model.request.CategoryRequest;
import com.example.todoreminder.repository.CategoryRepository;
import com.example.todoreminder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final CategoryMapper categoryMapper;

    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Category with id: " + id + "can not be found."));

        return categoryMapper.categoryDto(category);
    }

    public List<CategoryDto> getCategoryByUserId(Long userId) {
        List<Category> categoryList = categoryRepository.findCategoryByUserUserid(userId);
        return categoryList.stream()
                .map(categoryMapper::categoryDto)
                .collect(Collectors.toList());
    }

    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(category);
    }

    public CategoryDto updateCategory(CategoryDto categoryDto) {
        Category category = categoryRepository.findById(categoryDto.getCategoryId()).orElseThrow(()
                -> new EntityNotFoundException("Category not found by id: " + categoryDto.getCategoryId()));
        category.setTitle(categoryDto.getTitle());
        Category updatedCategory = categoryRepository.save(category);
        return categoryMapper.categoryDto(updatedCategory);
    }

    public void createCategory(Long userId, CategoryRequest categoryRequest) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        categoryRepository.save(categoryMapper.createCategory(user, categoryRequest));
    }

}
