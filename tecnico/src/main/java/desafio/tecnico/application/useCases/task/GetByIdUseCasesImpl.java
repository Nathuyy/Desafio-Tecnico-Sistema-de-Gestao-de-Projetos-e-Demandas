package desafio.tecnico.application.useCases.task;

import java.util.UUID;

import desafio.tecnico.application.gateways.task.GetByIdGateway;
import desafio.tecnico.domain.entities.Task;

public class GetByIdUseCasesImpl implements GetByIdGateway {
    private final GetByIdGateway getByIdGateway;

    public GetByIdUseCasesImpl(GetByIdGateway getByIdGateway){
        this.getByIdGateway = getByIdGateway;
    }

    @Override
    public Task execute(UUID id) {
        return getByIdGateway.execute(id);
    }   
}
