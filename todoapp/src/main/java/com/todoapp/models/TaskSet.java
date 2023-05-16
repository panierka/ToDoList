package com.todoapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name="task_set")
@Getter
@Setter
public class TaskSet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "taskSet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TodoTask> tasks;
}
