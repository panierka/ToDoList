package com.todoapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="task")
@ToString
@Getter
@Setter
public class TodoTask {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"content\"")
    private String content;

    @Column(name = "is_completed")
    private boolean isCompleted;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private LocalDateTime deadline;

    @Column(name = "\"order\"", nullable = false)
    private Integer order = 0;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_set_id")
    private TaskSet taskSet;

}
