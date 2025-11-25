package desafio.tecnico.application.gateways.task;

import java.util.List;

import desafio.tecnico.domain.entities.Task;

public interface GetAllTasksGateway {
    List<Task> execute();
}
