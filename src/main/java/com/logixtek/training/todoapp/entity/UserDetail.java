package com.logixtek.training.todoapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDetail {
    private User user = new User();

    private List<Task> todoList = new ArrayList<>();
}
