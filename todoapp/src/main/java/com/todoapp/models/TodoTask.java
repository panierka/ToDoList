package com.todoapp.models;

import jakarta.persistence.*;

@Entity
@Table(name="task")
public class TodoTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @Column(name = "is_completed")
    private boolean isCompleted;
}
