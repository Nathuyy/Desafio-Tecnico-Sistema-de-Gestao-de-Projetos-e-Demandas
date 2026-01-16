package desafio.tecnico.infrastructure.gateways.task;

import java.util.UUID;

import org.springframework.stereotype.Service;

import desafio.tecnico.application.gateways.task.UpdateTaskStatusGateway;
import desafio.tecnico.domain.enums.tasks.StatusEnum;
import desafio.tecnico.infrastructure.persistence.entities.TaskEntity;
import desafio.tecnico.infrastructure.persistence.repositories.TaskRepository;

@Service
public class UpdateTaskStatusGatewayImpl implements UpdateTaskStatusGateway {
    private final TaskRepository repository;

    public UpdateTaskStatusGatewayImpl(TaskRepository repository){
        this.repository = repository;
    }

    @Override
    public void execute(UUID id, StatusEnum status) {
        TaskEntity task = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Task não encontrada")); // trocar a excption

        task.setStatus(status);
        repository.save(task); 
    }
    
}
