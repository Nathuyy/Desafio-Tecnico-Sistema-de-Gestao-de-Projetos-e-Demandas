package desafio.tecnico.application.gateways.task;

import java.util.List;

import desafio.tecnico.domain.TaskParams;
import desafio.tecnico.domain.entities.Task;

public interface FindByParamsTaskGateway {
    List<Task> execute(TaskParams params);
}
