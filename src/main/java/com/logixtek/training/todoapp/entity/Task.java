package com.logixtek.training.todoapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    private long id;

    private long userId;

    private String title;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date doAt;

    private Boolean status;

}
