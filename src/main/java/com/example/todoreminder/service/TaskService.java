package com.example.todoreminder.service;


import com.example.todoreminder.entity.Category;
import com.example.todoreminder.entity.Task;
import com.example.todoreminder.entity.User;
import com.example.todoreminder.mapper.TaskMapper;
import com.example.todoreminder.model.dto.TaskDto;
import com.example.todoreminder.model.request.TaskRequest;
import com.example.todoreminder.repository.CategoryRepository;
import com.example.todoreminder.repository.TaskRepository;
import com.example.todoreminder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final CategoryRepository categoryRepository;

    private final UserRepository userRepository;

    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Task couldn't find with id: " + id));
        return taskMapper.toDto(task);
    }

    public List<TaskDto> getTaskByUserId(Long userId) {
        List<Task> taskList = taskRepository.findTaskByUserUserid(userId);
        return taskList.stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<TaskDto> getTaskByCategoryId(Long categoryId) {
        List<Task> taskList = taskRepository.findTaskByCategoryCategoryid(categoryId);
        return taskList.stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setUpdatedDate(LocalDate.now());
        task.setUpdatedTime(LocalTime.now());
        task.setCompleted(true);
        taskRepository.save(task);
    }

    public TaskDto updateTask(Long taskId, TaskRequest taskRequest) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new EntityNotFoundException("Task couldn't find with id: " + taskId)
        );
        task.setTitle(taskRequest.getTitle());

        Task updatedTask = taskRepository.save(task);
        return taskMapper.toDto(updatedTask);
    }

    public void createTask(Long categoryId, Long userId, TaskRequest taskRequest) throws Exception {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new EntityNotFoundException("Category not found!")
        );

        User user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("User not found!")
        );
        taskRepository.save(taskMapper.createTask(category, user, taskRequest));
    }

    public List<TaskDto> getUsersCompletedTasks(Long userId) {
        List<TaskDto> taskDtoList = taskMapper.listToDto(taskRepository.findTaskByUserUserid(userId));
        return taskDtoList.stream().filter(taskDto -> taskDto.isCompleted() == true).collect(Collectors.toList());
    }

    public List<TaskDto> getUsersIncompleteTasks(Long userId) {
        List<TaskDto> taskDtoList = taskMapper.listToDto(taskRepository.findTaskByUserUserid(userId));
        return taskDtoList.stream().filter(taskDto -> taskDto.isCompleted() == false).collect(Collectors.toList());
    }

    public List<TaskDto> getCompletedTasksOfCategory(Long categoryId) {
        List<TaskDto> taskDtoList = taskMapper.listToDto(taskRepository.findTaskByCategoryCategoryid(categoryId));
        return taskDtoList.stream().filter(taskDto -> taskDto.isCompleted() == true).collect(Collectors.toList());
    }

    public List<TaskDto> getIncompleteTasksOfCategory(Long categoryId) {
        List<TaskDto> taskDtoList = taskMapper.listToDto(taskRepository.findTaskByCategoryCategoryid(categoryId));
        return taskDtoList.stream().filter(taskDto -> taskDto.isCompleted() == false).collect(Collectors.toList());
    }

}
