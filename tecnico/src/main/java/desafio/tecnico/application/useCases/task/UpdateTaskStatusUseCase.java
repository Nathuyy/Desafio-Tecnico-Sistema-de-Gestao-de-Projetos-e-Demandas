package desafio.tecnico.application.useCases.task;

import java.util.UUID;

import desafio.tecnico.application.gateways.task.UpdateTaskStatusGateway;

public class UpdateTaskStatusUseCase implements UpdateTaskStatusGateway {
    private final UpdateTaskStatusGateway updateTaskStatusGateway;

    public UpdateTaskStatusUseCase(UpdateTaskStatusGateway updateTaskStatusGateway){
        this.updateTaskStatusGateway = updateTaskStatusGateway;
    }

    @Override
    public void execute(UUID id) {
        updateTaskStatusGateway.execute(id);
    }
}
