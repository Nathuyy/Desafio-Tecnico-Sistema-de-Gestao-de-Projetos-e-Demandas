package desafio.tecnico.application.useCases.project;

import java.util.UUID;

import desafio.tecnico.application.gateways.project.GetByIdGateway;
import desafio.tecnico.domain.entities.Project;

public class GetByIdUseCase {
    private final GetByIdGateway gateway;

    public GetByIdUseCase(GetByIdGateway gateway){
        this.gateway = gateway;
    }

    public Project execute(UUID id) {
        return gateway.execute(id);
    }  
}
