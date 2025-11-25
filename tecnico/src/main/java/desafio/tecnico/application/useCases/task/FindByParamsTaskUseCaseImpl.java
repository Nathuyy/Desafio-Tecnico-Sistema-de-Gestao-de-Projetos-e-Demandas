package desafio.tecnico.application.useCases.task;

import desafio.tecnico.application.gateways.task.FindByParamsTaskGateway;
import desafio.tecnico.domain.entities.Task;
import desafio.tecnico.domain.enums.tasks.PriorityEnum;
import desafio.tecnico.domain.enums.tasks.StatusEnum;

public class FindByParamsTaskUseCaseImpl implements FindByParamsTaskGateway {
    private final FindByParamsTaskGateway findByParamsTaskGateway;

    public FindByParamsTaskUseCaseImpl(FindByParamsTaskGateway findByParamsTaskGateway){
        this.findByParamsTaskGateway = findByParamsTaskGateway;
    }

    @Override
    public Task execute(StatusEnum status, PriorityEnum priority) {
        return findByParamsTaskGateway.execute(status, priority);
    }  
}
