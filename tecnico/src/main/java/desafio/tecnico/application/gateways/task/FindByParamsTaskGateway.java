package desafio.tecnico.application.gateways.task;

import desafio.tecnico.domain.entities.Task;
import desafio.tecnico.domain.enums.tasks.PriorityEnum;
import desafio.tecnico.domain.enums.tasks.StatusEnum;

public interface FindByParamsTaskGateway {
    Task execute(StatusEnum status, PriorityEnum priority);
}
