package desafio.tecnico.infrastructure.gateways.task;

import java.util.List;

import org.springframework.stereotype.Service;

import desafio.tecnico.application.gateways.task.GetAllTasksGateway;
import desafio.tecnico.domain.entities.Task;
import desafio.tecnico.infrastructure.mapper.TaskEntityMapper;
import desafio.tecnico.infrastructure.persistence.repositories.TaskRepository;

@Service
public class GetAllTasksGatewayImpl implements GetAllTasksGateway {
    private final TaskRepository repository;
    private final TaskEntityMapper mapper;

    public GetAllTasksGatewayImpl(TaskRepository repository, TaskEntityMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Task> execute() {
        return repository.findAll()
            .stream()
            .map(mapper::toDomain)
            .toList();
    }
    
}
