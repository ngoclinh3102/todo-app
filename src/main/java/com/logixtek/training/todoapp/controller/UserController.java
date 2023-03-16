package com.logixtek.training.todoapp.controller;

import com.logixtek.training.todoapp.model.response.UserResponse;
import com.logixtek.training.todoapp.model.entity.Task;
import com.logixtek.training.todoapp.model.entity.User;
import com.logixtek.training.todoapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user/create")
    public UserResponse createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/user/{id}")
    public UserResponse getUser(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user/{userId}/add-task")
    public UserResponse addTask(@PathVariable String userId, @RequestBody Task task) {
        return userService.addTask(userId,task);
    }

    @DeleteMapping("/user/{userId}/remove-task/{taskId}")
    public UserResponse removeTask(@PathVariable String userId, @PathVariable String taskId) {
        return userService.removeTask(userId, taskId);
    }

    @PutMapping("/user/{userId}/complete-task/{taskId}")
    public UserResponse completeTask(@PathVariable String userId, @PathVariable String taskId) {
        return userService.completeTask(userId, taskId);
    }
}
