package desafio.tecnico.application.gateways.project;

import java.util.List;

import desafio.tecnico.domain.entities.Project;

public interface GetAllProjectsGateway {
    List<Project> execute();
}
