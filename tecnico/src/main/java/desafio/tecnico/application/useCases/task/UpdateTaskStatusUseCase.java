package desafio.tecnico.application.useCases.task;

import java.util.UUID;

import desafio.tecnico.application.gateways.task.UpdateTaskStatusGateway;
import desafio.tecnico.domain.enums.tasks.StatusEnum;

public class UpdateTaskStatusUseCase {
    private final UpdateTaskStatusGateway updateTaskStatusGateway;

    public UpdateTaskStatusUseCase(UpdateTaskStatusGateway updateTaskStatusGateway){
        this.updateTaskStatusGateway = updateTaskStatusGateway;
    }

    public void execute(UUID id, StatusEnum status) {
        updateTaskStatusGateway.execute(id, status);
    }
}
