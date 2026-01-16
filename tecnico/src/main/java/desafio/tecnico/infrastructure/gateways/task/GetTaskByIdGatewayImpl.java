package desafio.tecnico.infrastructure.gateways.task;

import java.util.UUID;

import org.springframework.stereotype.Service;

import desafio.tecnico.application.gateways.task.GetByIdGateway;
import desafio.tecnico.domain.entities.Task;
import desafio.tecnico.infrastructure.mapper.TaskEntityMapper;
import desafio.tecnico.infrastructure.persistence.entities.TaskEntity;
import desafio.tecnico.infrastructure.persistence.repositories.TaskRepository;

@Service
public class GetTaskByIdGatewayImpl implements GetByIdGateway {
    private final TaskRepository repository;
    private final TaskEntityMapper mapper;

    public GetTaskByIdGatewayImpl(TaskRepository repository, TaskEntityMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Task execute(UUID id) {
        TaskEntity taskEntity = repository.getById(id);
        return mapper.toDomain(taskEntity);
    }

}
