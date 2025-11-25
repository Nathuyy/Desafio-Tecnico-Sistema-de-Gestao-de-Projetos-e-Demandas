package desafio.tecnico.application.useCases.project;

import desafio.tecnico.application.gateways.project.CreateProjectGateway;
import desafio.tecnico.domain.entities.Project;

public class CreateProjectUseCase {

    private final CreateProjectGateway gateway;

    public CreateProjectUseCase(CreateProjectGateway gateway){
        this.gateway = gateway;
    }

    public Project execute(Project project){
        return gateway.execute(project);
    }
}
