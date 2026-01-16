package desafio.tecnico.infrastructure.gateways.task;

import java.util.UUID;

import org.springframework.stereotype.Service;

import desafio.tecnico.application.gateways.task.DeleteTaskGateway;
import desafio.tecnico.infrastructure.persistence.repositories.TaskRepository;

@Service
public class DeleteTaskGatewayImpl implements DeleteTaskGateway {
    private final TaskRepository repository;

    public DeleteTaskGatewayImpl(TaskRepository repository){
        this.repository = repository;
    }

    @Override
    public void execute(UUID id) {
        repository.deleteById(id);
    }
}
