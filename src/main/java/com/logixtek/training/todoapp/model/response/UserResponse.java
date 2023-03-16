package com.logixtek.training.todoapp.model.response;

import com.logixtek.training.todoapp.model.entity.Task;
import com.logixtek.training.todoapp.model.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserResponse {
    private User user = new User();

    private List<Task> todoList = new ArrayList<>();
}
