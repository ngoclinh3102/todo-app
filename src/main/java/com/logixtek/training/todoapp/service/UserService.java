package com.logixtek.training.todoapp.service;

import com.logixtek.training.todoapp.model.response.UserResponse;
import com.logixtek.training.todoapp.model.entity.Task;
import com.logixtek.training.todoapp.model.entity.User;
import com.logixtek.training.todoapp.repository.TaskRepository;
import com.logixtek.training.todoapp.repository.UserRepository;
import com.logixtek.training.todoapp.utils.GlobalUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public UserResponse createUser(User user) {
        user.setId(GlobalUtils.generateId());
        user = userRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setUser(user);

        return userResponse;
    }

    public UserResponse getUserById(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        List<Task> todoList = taskRepository.getUserTaskList(userId);

        UserResponse userResponse = new UserResponse();
        userResponse.setUser(user);
        userResponse.setTodoList(todoList);

        return userResponse;
    }

    public UserResponse addTask(String userId, Task task) {
        task.setId(GlobalUtils.generateId());
        task.setUserId(userId);

        taskRepository.save(task);

        return getUserById(userId);
    }

    public UserResponse removeTask(String userId, String taskId) {
        taskRepository.deleteById(taskId);
        return getUserById(userId);
    }

    public UserResponse completeTask(String userId, String taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task != null && task.getUserId().equals(userId)) {
            task.setStatus(true);
            taskRepository.save(task);
        }
        return getUserById(userId);
    }

    public UserResponse unCompleteTask(String userId, String taskId) {
        return null;
    }
}
