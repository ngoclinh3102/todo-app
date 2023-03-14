package com.logixtek.training.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logixtek.training.todoapp.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}