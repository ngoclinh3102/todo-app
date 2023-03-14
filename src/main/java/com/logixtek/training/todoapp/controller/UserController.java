package com.logixtek.training.todoapp.controller;

import com.logixtek.training.todoapp.entity.User;
import com.logixtek.training.todoapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/create")
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/user/{id}")
    public User getById(@PathVariable long id) {
        return userService.findById(id);
    }

    @GetMapping("/user/all")
    public List<User> getAll() {
        return userService.findAll();
    }

    @PutMapping("/user/update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/user/delete/{id}")
    public String delete(@PathVariable long id) {
        return userService.delete(id);
    }
}
