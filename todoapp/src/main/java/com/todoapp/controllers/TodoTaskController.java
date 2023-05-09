package com.todoapp.controllers;

import com.todoapp.models.TodoTask;
import com.todoapp.services.TodoTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TodoTaskController {
    @Autowired
    private TodoTaskService service;

    @GetMapping(value = "/task/get-all")
    public List<TodoTask> getAllTasks(){
        var tasks = service.getAllTasks();
        log.info("getting {} tasks", tasks.size());
        return tasks;
    }
}
