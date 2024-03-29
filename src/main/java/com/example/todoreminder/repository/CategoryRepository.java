package com.example.todoreminder.repository;

import com.example.todoreminder.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


   List<Category> findCategoryByUserUserid(Long userId);

}
