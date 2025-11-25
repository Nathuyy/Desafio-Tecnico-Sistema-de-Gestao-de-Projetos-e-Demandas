package desafio.tecnico.application.gateways.task;

import java.util.UUID;

public interface DeleteTaskGateway {
    void execute(UUID id);
}
