package com.example.todoreminder.mapper;

import com.example.todoreminder.entity.Category;
import com.example.todoreminder.entity.Task;
import com.example.todoreminder.entity.User;
import com.example.todoreminder.model.dto.TaskDto;
import com.example.todoreminder.model.request.TaskRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TaskMapper {


    public TaskDto toDto(Task task) {

        return TaskDto.builder()
                .taskId(task.getTaskid())
                .title(task.getTitle())
                .isCompleted(task.isCompleted())
                .createdDate(task.getCreatedDate())
                .createdTime(task.getCreatedTime())
                .build();
    }

    public Task createTask(Category category, User user, TaskRequest taskRequest) {
        return Task.builder()
                .title(taskRequest.getTitle())
                .category(category)
                .user(user)
                .createdDate(LocalDate.now())
                .createdTime(LocalTime.now())
                .build();
    }

    public List<TaskDto> listToDto(List<Task> tasks){
        return tasks.stream().map(this::toDto).collect(Collectors.toList());
    }

}
