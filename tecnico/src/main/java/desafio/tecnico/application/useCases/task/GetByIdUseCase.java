package desafio.tecnico.application.useCases.task;

import java.util.UUID;

import desafio.tecnico.application.gateways.task.GetByIdGateway;
import desafio.tecnico.domain.entities.Task;

public class GetByIdUseCase {
    private final GetByIdGateway getByIdGateway;

    public GetByIdUseCase(GetByIdGateway getByIdGateway){
        this.getByIdGateway = getByIdGateway;
    }

    public Task execute(UUID id) {
        return getByIdGateway.execute(id);
    }   
}
