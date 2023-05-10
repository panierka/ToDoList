package com.todoapp.services;

import com.todoapp.models.TodoTask;
import com.todoapp.repositories.TodoTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoTaskService {
    @Autowired
    private TodoTaskRepository repository;

    public List<TodoTask> getAllTasks(){
        return repository.findAll();
    }
}
