    package desafio.tecnico.web.controllers;

    import java.util.List;
    import java.util.UUID;

    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import desafio.tecnico.application.useCases.project.CreateProjectUseCase;
    import desafio.tecnico.application.useCases.project.GetAllProjectsUseCase;
    import desafio.tecnico.application.useCases.project.GetByIdUseCase;
    import desafio.tecnico.domain.entities.Project;
    import desafio.tecnico.web.dto.ProjectRequestDto;
    import desafio.tecnico.web.dto.ProjectResponseDto;
    import desafio.tecnico.web.mappers.ProjectMapper;
    import jakarta.validation.Valid;

    @RestController
    @RequestMapping("/projects")
    public class ProjectController {

        private final ProjectMapper mapper;
        private final CreateProjectUseCase createUseCase;
        private final GetAllProjectsUseCase gettAllUseCase;
        private final GetByIdUseCase getByIdUseCase;

        public ProjectController(CreateProjectUseCase createUseCase, GetAllProjectsUseCase gettAllUseCase, GetByIdUseCase getByIdUseCase, ProjectMapper mapper){
            this.createUseCase = createUseCase;
            this.gettAllUseCase = gettAllUseCase;
            this.getByIdUseCase = getByIdUseCase;
            this.mapper = mapper;
        }

        @PostMapping
        public ResponseEntity<ProjectResponseDto> create(@Valid @RequestBody ProjectRequestDto request){
            Project project = createUseCase.execute(mapper.toDomain(request));
            return ResponseEntity.ok(mapper.toResponse(project));
        }

        @GetMapping
        public ResponseEntity<List<ProjectResponseDto>> getAll() {
            List<Project> projects = gettAllUseCase.execute();
            return ResponseEntity.ok(mapper.toResponseList(projects));
        }

        @GetMapping("/{id}")
        public ResponseEntity<ProjectResponseDto> getById(@PathVariable UUID id) {
            Project project = getByIdUseCase.execute(id);
            return ResponseEntity.ok(mapper.toResponse(project));
        }
    }
