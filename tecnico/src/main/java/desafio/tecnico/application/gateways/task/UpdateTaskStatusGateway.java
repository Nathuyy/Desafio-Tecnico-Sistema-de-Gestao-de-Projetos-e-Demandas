package desafio.tecnico.application.gateways.task;

import java.util.UUID;

public interface UpdateTaskStatusGateway {
    void execute(UUID id);
}
