package desafio.tecnico.application.useCases.project;

import java.util.List;

import desafio.tecnico.application.gateways.project.GetAllProjectsGateway;
import desafio.tecnico.domain.entities.Project;

public class GetAllProjectsUseCase {
    private final GetAllProjectsGateway gateway;

    public GetAllProjectsUseCase(GetAllProjectsGateway gateway){
        this.gateway = gateway;
    }

    public List<Project> execute() {
        return gateway.execute();  
    }
}
