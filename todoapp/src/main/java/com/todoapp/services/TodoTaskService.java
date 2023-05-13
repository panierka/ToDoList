package com.todoapp.services;

import com.todoapp.models.TodoTask;
import com.todoapp.repositories.TodoTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoTaskService {
    @Autowired
    private TodoTaskRepository repository;

    public List<TodoTask> getAllTasks(){
        return repository.findAll();
    }

    public TodoTask updateTask(TodoTask task){
        return repository.save(task);
    }

    public Optional<TodoTask> findTaskById(Long id){
        return repository.findById(id);
    }

    public TodoTask createTask(TodoTask task){
        return repository.save(task);
    }

    public void deleteTask(TodoTask task){
        repository.delete(task);
    }
}
