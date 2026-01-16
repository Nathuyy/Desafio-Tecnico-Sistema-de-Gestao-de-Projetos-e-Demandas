package desafio.tecnico.application.useCases.task;

import desafio.tecnico.application.gateways.task.CreateTaskGateway;
import desafio.tecnico.domain.entities.Task;

public class CreateTaskUseCase {
    private final CreateTaskGateway createTaskGateway;

    public CreateTaskUseCase(CreateTaskGateway createTaskGateway){
        this.createTaskGateway = createTaskGateway;
    }

    public Task execute(Task task) {
        return createTaskGateway.execute(task);
    }
}
