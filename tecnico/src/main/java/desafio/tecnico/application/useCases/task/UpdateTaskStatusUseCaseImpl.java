package desafio.tecnico.application.useCases.task;

import java.util.UUID;

import desafio.tecnico.application.gateways.task.UpdateTaskStatusGateway;

public class UpdateTaskStatusUseCaseImpl implements UpdateTaskStatusGateway {
    private final UpdateTaskStatusGateway updateTaskStatusGateway;

    public UpdateTaskStatusUseCaseImpl(UpdateTaskStatusGateway updateTaskStatusGateway){
        this.updateTaskStatusGateway = updateTaskStatusGateway;
    }

    @Override
    public void execute(UUID id) {
        updateTaskStatusGateway.execute(id);
    }
}
