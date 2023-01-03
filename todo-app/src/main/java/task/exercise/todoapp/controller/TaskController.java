package task.exercise.todoapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import task.exercise.todoapp.model.Task;
import org.springframework.data.domain.Pageable;
import task.exercise.todoapp.model.TaskRepository;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
public class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository repository;


    TaskController(final TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/tasks", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Task>> readAllTasks() {
        logger.warn("Exposing all the tasks!");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(path = "/tasks")
    ResponseEntity<?> readAllTasks(Pageable page) {
        logger.warn("Custom pageable");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }

    @PutMapping(path = "/tasks/{id}")
    ResponseEntity<?> updateTask(@PathVariable long id,@RequestBody @Valid Task toUpdate) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        repository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/tasks/{id}")
    ResponseEntity<Task> readTask(@PathVariable long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/tasks/{id}")
    ResponseEntity<Task> createTask(@RequestBody @Valid Task toCreate) {
        Task result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @Transactional
    @PatchMapping(path = "/tasks/{id}")
    public ResponseEntity<?> toggleTask(@PathVariable long id){
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(task -> {
                   task.setDone(!task.isDone());
                });
        return ResponseEntity.noContent().build();

    }



}
