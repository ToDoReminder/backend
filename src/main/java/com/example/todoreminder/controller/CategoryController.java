package com.example.todoreminder.controller;

import com.example.todoreminder.mapper.CategoryMapper;
import com.example.todoreminder.model.dto.CategoryDto;
import com.example.todoreminder.model.request.CategoryRequest;
import com.example.todoreminder.repository.CategoryRepository;
import com.example.todoreminder.repository.UserRepository;
import com.example.todoreminder.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id) {

        return categoryService.getCategoryById(id);
    }

    @GetMapping("/users/{userId}")
    public List<CategoryDto> getCategoriesByUserId(@PathVariable Long userId) {
        return categoryService.getCategoryByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category is deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>  updateCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok("Category is updated successfully!");
    }

    @PostMapping("/create/users/{userId}")
    public ResponseEntity<String> createCategoryToAUser(@PathVariable Long userId, @RequestBody CategoryRequest categoryRequest) throws  Exception {
        categoryService.createCategory(userId, categoryRequest);
        return ResponseEntity.ok("Category is added to the user successfully!");

    }

}
