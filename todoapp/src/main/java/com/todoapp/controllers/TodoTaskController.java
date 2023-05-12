package com.todoapp.controllers;

import com.todoapp.models.TodoTask;
import com.todoapp.services.TodoTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/task/update/{id}")
    public ResponseEntity<TodoTask> updateTask(@RequestBody TodoTask newTask, @PathVariable Long id) {
        log.info("put");
        if (newTask == null){
            return (ResponseEntity<TodoTask>) ResponseEntity.badRequest();
        }
        var task = service
                .findTaskById(newTask.getId())
                .map(x -> {
                    x.setContent(newTask.getContent());
                    x.setCompleted(newTask.isCompleted());
                    x.setDescription(newTask.getDescription());
                    x.setDeadline(newTask.getDeadline());
                    x.setOrder(newTask.getOrder());
                    log.info("updating task with id {}: {}", id, x.toString());
                    return service.updateTask(x);
                })
                .orElseGet(() -> {
                    log.info("creating a new task at id {}: {}", id, newTask.toString());
                    return service.updateTask(newTask);
                });
        return ResponseEntity.ok(task);
    }
}
