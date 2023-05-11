package com.todoapp.controllers;

import com.todoapp.models.TodoTask;
import com.todoapp.services.TodoTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class TodoTaskController {
    @Autowired
    private TodoTaskService service;

    @GetMapping(value = "/task/get-all")
    public List<TodoTask> getAllTasks(){
        var tasks = service
                .getAllTasks()
                .stream()
                .sorted(Comparator.comparing(TodoTask::getOrder))
                .toList();
        log.info("getting {} tasks", tasks.size());
        return tasks;
    }
}
