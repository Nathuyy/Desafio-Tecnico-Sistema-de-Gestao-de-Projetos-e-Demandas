package desafio.tecnico.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import desafio.tecnico.application.gateways.task.CreateTaskGateway;
import desafio.tecnico.application.gateways.task.DeleteTaskGateway;
import desafio.tecnico.application.gateways.task.FindByParamsTaskGateway;
import desafio.tecnico.application.gateways.task.GetAllTasksGateway;
import desafio.tecnico.application.gateways.task.GetByIdGateway;
import desafio.tecnico.application.gateways.task.UpdateTaskStatusGateway;
import desafio.tecnico.application.useCases.task.CreateTaskUseCase;
import desafio.tecnico.application.useCases.task.DeleteTaskUseCase;
import desafio.tecnico.application.useCases.task.FindByParamsTaskUseCase;
import desafio.tecnico.application.useCases.task.GetAllTasksUseCase;
import desafio.tecnico.application.useCases.task.GetByIdUseCase;
import desafio.tecnico.application.useCases.task.UpdateTaskStatusUseCase;

@Configuration
public class TaskUseCaseConfig {
    
    @Bean
    public CreateTaskUseCase createTaskUseCase(CreateTaskGateway gateway){
        return new CreateTaskUseCase(gateway);
    }

    @Bean
    public DeleteTaskUseCase deleteTaskUseCase(DeleteTaskGateway gateway){
        return new DeleteTaskUseCase(gateway);
    }

    @Bean
    public FindByParamsTaskUseCase findByParamsTaskUseCase(FindByParamsTaskGateway gateway){
        return new FindByParamsTaskUseCase(gateway);
    }

    @Bean
    public GetAllTasksUseCase getAllTasksUseCase(GetAllTasksGateway gateway){
        return new GetAllTasksUseCase(gateway);
    }

    @Bean
    public GetByIdUseCase getByIdTaskUseCase(GetByIdGateway gateway){
        return new GetByIdUseCase(gateway);
    }

    @Bean
    public UpdateTaskStatusUseCase updateTaskStatusUseCase(UpdateTaskStatusGateway gateway){
        return new UpdateTaskStatusUseCase(gateway);
    }
}
