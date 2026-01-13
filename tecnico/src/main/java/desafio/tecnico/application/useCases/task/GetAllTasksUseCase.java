package desafio.tecnico.application.useCases.task;

import java.util.List;

import desafio.tecnico.application.gateways.task.GetAllTasksGateway;
import desafio.tecnico.domain.entities.Task;

public class GetAllTasksUseCase implements GetAllTasksGateway {
    private final GetAllTasksGateway getAllProjectsGateway;

    public GetAllTasksUseCase(GetAllTasksGateway getAllProjectsGateway){
        this.getAllProjectsGateway = getAllProjectsGateway;
    }

    @Override
    public List<Task> execute() {
        return getAllProjectsGateway.execute();
    }
    
}
