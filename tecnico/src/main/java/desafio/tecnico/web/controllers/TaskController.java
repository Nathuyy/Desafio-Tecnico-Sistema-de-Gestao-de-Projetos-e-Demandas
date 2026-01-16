package desafio.tecnico.web.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.tecnico.application.useCases.TaskUseCases;
import desafio.tecnico.domain.TaskParams;
import desafio.tecnico.domain.entities.Task;
import desafio.tecnico.web.dto.task.TaskRequestDto;
import desafio.tecnico.web.dto.task.TaskResponseDto;
import desafio.tecnico.web.mappers.TaskMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskMapper mapper;
    private final TaskUseCases useCases;

    public TaskController(TaskMapper mapper, TaskUseCases useCases){
        this.mapper = mapper;
        this.useCases = useCases;
    }

    @PostMapping
    public ResponseEntity<TaskResponseDto> create(@Valid @RequestBody TaskRequestDto request){
        Task task = useCases.create().execute(mapper.toDomain(request));
        return ResponseEntity.ok(mapper.toResponse(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        useCases.delete().execute(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/filter")
    public ResponseEntity<List<TaskResponseDto>> findByParams(@RequestBody TaskParams request){
        List<Task> tasks = useCases.findByParams().execute(request);
        return ResponseEntity.ok(mapper.toResponseList(tasks));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getAll(){
        List<Task> tasks = useCases.getAll().execute();
        return ResponseEntity.ok(mapper.toResponseList(tasks));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getById(@PathVariable UUID id){
        Task task = useCases.getById().execute(id);
        return ResponseEntity.ok(mapper.toResponse(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateStatus(@PathVariable UUID id, @RequestBody TaskParams request){
        useCases.updateStatus().execute(id, request.getStatus());
        return ResponseEntity.ok().build();
    }
}
