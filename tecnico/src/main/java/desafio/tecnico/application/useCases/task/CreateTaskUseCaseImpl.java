package desafio.tecnico.application.useCases.task;

import desafio.tecnico.application.gateways.task.CreateTaskGateway;
import desafio.tecnico.domain.entities.Task;

public class CreateTaskUseCaseImpl implements CreateTaskGateway {
    private final CreateTaskGateway createTaskGateway;

    public CreateTaskUseCaseImpl(CreateTaskGateway createTaskGateway){
        this.createTaskGateway = createTaskGateway;
    }

    @Override
    public Task execute(Task task) {
        return createTaskGateway.execute(task);
    }
}
