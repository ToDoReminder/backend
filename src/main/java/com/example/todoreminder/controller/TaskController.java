package com.example.todoreminder.controller;


import com.example.todoreminder.model.dto.TaskDto;
import com.example.todoreminder.model.request.TaskRequest;
import com.example.todoreminder.service.AuthorizationService;
import com.example.todoreminder.service.TaskService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    private final AuthorizationService authorizationService;

    // GET TASKS BY TASKID
    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {

        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    //GET ALL TASKS OF A USER [gets both finished and unfinished tasks]
    @GetMapping("/users/{userId}")
    public List<TaskDto> getTasksByUserId(@PathVariable Long userId) {
        return taskService.getTaskByUserId(userId);
    }

    //GET ALL TASKS OF A CATEGORY [gets both finished and unfinished tasks]
    @GetMapping("/categories/{categoryId}")
    public List<TaskDto> getTasksOfACategory(@PathVariable Long categoryId) {
        return taskService.getTaskByCategoryId(categoryId);
    }

    //GET USER'S COMPLETED TASKS
    @GetMapping("users/completed/{userId}")
    public List<TaskDto> getUsersCompletedTasks(@PathVariable Long userId) {
        return taskService.getUsersCompletedTasks(userId);
    }

    //GET USER'S INCOMPLETE TASKS
    @GetMapping("users/incomplete/{userId}")
    public List<TaskDto> getUsersIncompleteTasks(@PathVariable Long userId) {
        return taskService.getUsersIncompleteTasks(userId);
    }

    //GET COMPLETED TASKS OF A CATEGORY
    @GetMapping("categories/completed/{categoryId}")
    public List<TaskDto> getCompletedTasksOfCategory(@PathVariable Long categoryId) {
        return taskService.getCompletedTasksOfCategory(categoryId);
    }

    //GET INCOMPLETE TASKS OF A CATEGORY
    @GetMapping("/categories/incomplete/{categoryId}")
    public List<TaskDto> getIncompleteTasksOfCategory(@PathVariable Long categoryId) {
        return taskService.getIncompleteTasksOfCategory(categoryId);
    }

    //CHANGE THE CONTENT OF A TASK
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody TaskRequest taskRequest) {
        taskService.updateTask(id, taskRequest);
        return ResponseEntity.ok("Task with id " + id + " is updated successfully!");
    }

    //DELETE TASK (is_completed will be true.)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task with id " + id + " is deleted succesfully!");
    }

    //CREATE A TASK TO SPECIFIC USER AND CATEGORY
    @PostMapping("/categories/{categoryId}/users/{userId}")
    public ResponseEntity<?> createTask(@PathVariable Long categoryId, @PathVariable Long userId, @RequestBody TaskRequest taskRequest) throws Exception {
        taskService.createTask(categoryId, userId, taskRequest);
        return ResponseEntity.ok("Task is added successfully to the category!");
    }
}
