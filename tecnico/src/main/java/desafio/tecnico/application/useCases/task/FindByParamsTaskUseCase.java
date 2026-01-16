package desafio.tecnico.application.useCases.task;

import java.util.List;

import desafio.tecnico.application.gateways.task.FindByParamsTaskGateway;
import desafio.tecnico.domain.TaskParams;
import desafio.tecnico.domain.entities.Task;

public class FindByParamsTaskUseCase {
    private final FindByParamsTaskGateway findByParamsTaskGateway;

    public FindByParamsTaskUseCase(FindByParamsTaskGateway findByParamsTaskGateway){
        this.findByParamsTaskGateway = findByParamsTaskGateway;
    }

    public List<Task> execute(TaskParams params) {
        return findByParamsTaskGateway.execute(params);
    }  
}
