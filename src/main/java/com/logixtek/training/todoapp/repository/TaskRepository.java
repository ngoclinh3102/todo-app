package com.logixtek.training.todoapp.repository;

import com.logixtek.training.todoapp.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, String> {

    @Query(value = "from Task where (userId = :userId)")
    List<Task> getUserTaskList(@Param("userId") String userId);

}
