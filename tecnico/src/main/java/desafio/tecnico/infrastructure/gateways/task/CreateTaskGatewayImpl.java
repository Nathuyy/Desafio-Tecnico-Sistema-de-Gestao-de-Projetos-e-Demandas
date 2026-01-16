package desafio.tecnico.infrastructure.gateways.task;

import org.springframework.stereotype.Service;

import desafio.tecnico.application.gateways.task.CreateTaskGateway;
import desafio.tecnico.domain.entities.Task;
import desafio.tecnico.domain.enums.tasks.StatusEnum;
import desafio.tecnico.infrastructure.mapper.TaskEntityMapper;
import desafio.tecnico.infrastructure.persistence.entities.TaskEntity;
import desafio.tecnico.infrastructure.persistence.repositories.TaskRepository;

@Service
public class CreateTaskGatewayImpl implements CreateTaskGateway {
    private final TaskRepository repository;
    private final TaskEntityMapper mapper;

    public CreateTaskGatewayImpl(TaskRepository repository, TaskEntityMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Task execute(Task task) {
        TaskEntity entity = mapper.toEntity(task);
        if (entity.getStatus() == null) {
            entity.setStatus(StatusEnum.TODO);
        }
        TaskEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }
}
