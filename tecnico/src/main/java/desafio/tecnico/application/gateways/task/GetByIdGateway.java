package desafio.tecnico.application.gateways.task;

import java.util.UUID;

import desafio.tecnico.domain.entities.Task;

public interface GetByIdGateway {
    Task execute(UUID id);

}
