package desafio.tecnico.application.gateways.project;

import java.util.UUID;

import desafio.tecnico.domain.entities.Project;

public interface GetByIdGateway {
    Project execute(UUID id);

}
