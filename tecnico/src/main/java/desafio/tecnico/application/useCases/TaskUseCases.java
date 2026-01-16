package desafio.tecnico.application.useCases;

import org.springframework.stereotype.Component;

import desafio.tecnico.application.useCases.task.CreateTaskUseCase;
import desafio.tecnico.application.useCases.task.DeleteTaskUseCase;
import desafio.tecnico.application.useCases.task.FindByParamsTaskUseCase;
import desafio.tecnico.application.useCases.task.GetAllTasksUseCase;
import desafio.tecnico.application.useCases.task.GetByIdUseCase;
import desafio.tecnico.application.useCases.task.UpdateTaskStatusUseCase;

@Component
public record TaskUseCases(CreateTaskUseCase create, DeleteTaskUseCase delete, FindByParamsTaskUseCase findByParams, GetAllTasksUseCase getAll,
    GetByIdUseCase getById, UpdateTaskStatusUseCase updateStatus) {
}