package desafio.tecnico.application.gateways.task;

import java.util.UUID;

import desafio.tecnico.domain.enums.tasks.StatusEnum;

public interface UpdateTaskStatusGateway {
    void execute(UUID id, StatusEnum status);
}
