package desafio.tecnico.application.gateways.project;

import desafio.tecnico.domain.entities.Project;

public interface CreateProjectGateway {
    Project execute(Project project);
}
