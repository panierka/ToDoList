package com.todoapp.controllers;

import com.todoapp.models.TodoTask;
import com.todoapp.services.TodoTaskService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@Slf4j
public class TodoTaskController {
    @Autowired
    private TodoTaskService service;

    @GetMapping(value = "/task/get-all")
    public ResponseEntity<List<TodoTask>> getAllTasks(){
        var tasks = service
                .getAllTasks()
                .stream()
                .sorted(Comparator.comparing(TodoTask::getOrder))
                .toList();
        log.info("getting {} tasks", tasks.size());
        return ResponseEntity.ok(tasks);
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

    @PutMapping("task/reorder")
    public void updateOrder(@RequestBody List<Long> orderedIndices){
        log.info("reordering");
        IntStream
                .range(0, orderedIndices.size())
                .forEach(orderedPosition -> {
                    var id = orderedIndices.get(orderedPosition);
                    var optionalTask = service.findTaskById(id);

                    if (optionalTask.isEmpty()){
                        return;
                    }

                    var task = optionalTask.get();
                    task.setOrder(orderedPosition + 1);
                    service.updateTask(task);
                });
    }

    @PostMapping("task/create")
    public ResponseEntity<TodoTask> createTask(@RequestBody TodoTask task){
        var createdTask = service.createTask(task);
        return ResponseEntity.ok(createdTask);
    }

    @DeleteMapping("task/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        var foundTask = service.findTaskById(id);
        if (foundTask.isPresent()){
            service.deleteTask(foundTask.get());
            return ResponseEntity.ok("task deleted");
        }

        return ResponseEntity.notFound().build();
    }
}
