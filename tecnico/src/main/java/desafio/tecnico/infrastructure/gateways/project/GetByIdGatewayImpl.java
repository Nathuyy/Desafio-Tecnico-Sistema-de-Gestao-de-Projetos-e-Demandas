package desafio.tecnico.infrastructure.gateways.project;

import java.util.UUID;

import org.springframework.stereotype.Service;

import desafio.tecnico.application.gateways.project.GetByIdGateway;
import desafio.tecnico.domain.entities.Project;
import desafio.tecnico.infrastructure.mapper.ProjectEntityMapper;
import desafio.tecnico.infrastructure.persistence.entities.ProjectEntity;
import desafio.tecnico.infrastructure.persistence.repositories.ProjectRepository;

@Service
public class GetByIdGatewayImpl implements GetByIdGateway {
    private final ProjectRepository repository;
    private final ProjectEntityMapper mapper;

    public GetByIdGatewayImpl(ProjectRepository repository, ProjectEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Project execute(UUID id) {
        ProjectEntity entity = repository.getById(id);
        return mapper.toDomain(entity);
    }

}
