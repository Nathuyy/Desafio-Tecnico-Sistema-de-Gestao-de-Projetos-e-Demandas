package desafio.tecnico.application.gateways.task;

import desafio.tecnico.domain.entities.Task;

public interface CreateTaskGateway {
    Task execute(Task task);
}
