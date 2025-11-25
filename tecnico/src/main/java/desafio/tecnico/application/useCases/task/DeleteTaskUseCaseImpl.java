package desafio.tecnico.application.useCases.task;

import java.util.UUID;

import desafio.tecnico.application.gateways.task.DeleteTaskGateway;

public class DeleteTaskUseCaseImpl implements DeleteTaskGateway {
    private final DeleteTaskGateway deleteTaskGateway;

    public DeleteTaskUseCaseImpl(DeleteTaskGateway deleteTaskGateway){
        this.deleteTaskGateway = deleteTaskGateway;
    }

    @Override
    public void execute(UUID id) {
        deleteTaskGateway.execute(id);
    }
    
}
