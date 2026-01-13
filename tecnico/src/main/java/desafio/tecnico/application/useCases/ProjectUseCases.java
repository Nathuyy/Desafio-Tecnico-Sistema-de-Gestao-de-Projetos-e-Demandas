package desafio.tecnico.application.useCases;

import org.springframework.stereotype.Component;

import desafio.tecnico.application.useCases.project.CreateProjectUseCase;
import desafio.tecnico.application.useCases.project.GetAllProjectsUseCase;
import desafio.tecnico.application.useCases.project.GetByIdUseCase;

@Component
public record ProjectUseCases(CreateProjectUseCase create, GetAllProjectsUseCase getAll, GetByIdUseCase getById) {
}
