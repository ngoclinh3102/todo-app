package com.logixtek.training.todoapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.logixtek.training.todoapp.entity.User;
import com.logixtek.training.todoapp.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User update(User user) {
        User existingUser = findById(user.getId());
        existingUser.setName(user.getName());
        existingUser.setMail(user.getMail());
        return save(existingUser);
    }

    public String delete(long id) {
        userRepository.deleteById(id);
        return "Delete successfully!";
    }
}
