package desafio.tecnico.infrastructure.gateways;

import org.springframework.stereotype.Service;

import desafio.tecnico.application.gateways.project.CreateProjectGateway;
import desafio.tecnico.domain.entities.Project;
import desafio.tecnico.infrastructure.mapper.ProjectEntityMapper;
import desafio.tecnico.infrastructure.persistence.entities.ProjectEntity;
import desafio.tecnico.infrastructure.persistence.repositories.ProjectRepository;

@Service
public class CreateProjectGatewayImpl implements CreateProjectGateway {

    private final ProjectRepository repository;
    private final ProjectEntityMapper mapper;

    public CreateProjectGatewayImpl(ProjectRepository repository, ProjectEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Project execute(Project project) {
        ProjectEntity entity = mapper.toEntity(project);
        ProjectEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }
}
