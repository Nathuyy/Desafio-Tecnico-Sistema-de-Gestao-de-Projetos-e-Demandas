package desafio.tecnico.infrastructure.gateways;

import java.util.List;

import org.springframework.stereotype.Service;

import desafio.tecnico.application.gateways.project.GetAllProjectsGateway;
import desafio.tecnico.domain.entities.Project;
import desafio.tecnico.infrastructure.mapper.ProjectEntityMapper;
import desafio.tecnico.infrastructure.persistence.repositories.ProjectRepository;

@Service
public class GetAllProjectsGatewayImpl implements GetAllProjectsGateway {
    private final ProjectRepository repository;
    private final ProjectEntityMapper mapper;

    public GetAllProjectsGatewayImpl(ProjectRepository repository, ProjectEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

	@Override
	public List<Project> execute() {
        return repository.findAll()
            .stream()
            .map(mapper::toDomain)
            .toList();
	}
}
