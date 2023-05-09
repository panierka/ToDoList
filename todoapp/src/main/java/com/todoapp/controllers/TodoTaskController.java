package com.todoapp.controllers;

import com.todoapp.models.TodoTask;
import com.todoapp.services.TodoTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TodoTaskController {
    @Autowired
    private TodoTaskService service;

    @GetMapping(value = "/task/get-all")
    public List<TodoTask> getAllTasks(){
        return service.getAllTasks();
    }
}
