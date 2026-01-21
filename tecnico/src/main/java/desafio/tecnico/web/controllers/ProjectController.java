package desafio.tecnico.web.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.tecnico.application.useCases.ProjectUseCases;
import desafio.tecnico.domain.entities.Project;
import desafio.tecnico.web.dto.project.ProjectRequestDto;
import desafio.tecnico.web.dto.project.ProjectResponseDto;
import desafio.tecnico.web.mappers.ProjectMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectMapper mapper;
    private final ProjectUseCases useCases;

    public ProjectController(ProjectMapper mapper, ProjectUseCases useCases) {
        this.mapper = mapper;
        this.useCases = useCases;
    }

    @PostMapping
    public ResponseEntity<ProjectResponseDto> create(@Valid @RequestBody ProjectRequestDto request) {
        Project project = useCases.create().execute(mapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(project));
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseDto>> getAll() {
        List<Project> projects = useCases.getAll().execute();
        return ResponseEntity.ok(mapper.toResponseList(projects));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDto> getById(@PathVariable UUID id) {
        Project project = useCases.getById().execute(id);
        return ResponseEntity.ok(mapper.toResponse(project));
    }
}
