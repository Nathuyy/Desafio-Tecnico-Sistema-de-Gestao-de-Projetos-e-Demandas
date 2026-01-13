package desafio.tecnico.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import desafio.tecnico.application.gateways.project.CreateProjectGateway;
import desafio.tecnico.application.gateways.project.GetAllProjectsGateway;
import desafio.tecnico.application.gateways.project.GetByIdGateway;
import desafio.tecnico.application.useCases.project.CreateProjectUseCase;
import desafio.tecnico.application.useCases.project.GetAllProjectsUseCase;
import desafio.tecnico.application.useCases.project.GetByIdUseCase;

@Configuration
public class ProjectUseCaseConfig {

    @Bean
    public CreateProjectUseCase createProjectUseCase(CreateProjectGateway gateway) {
        return new CreateProjectUseCase(gateway);
    }

    @Bean
    public GetAllProjectsUseCase getAllProjectsUseCase(GetAllProjectsGateway gateway) {
        return new GetAllProjectsUseCase(gateway);
    }

    @Bean
    public GetByIdUseCase getByIdUseCase(GetByIdGateway gateway) {
        return new GetByIdUseCase(gateway);
    }
}
