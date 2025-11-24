package desafio.tecnico.domain.repositories;

import java.util.List;
import java.util.UUID;

import desafio.tecnico.domain.entities.Project;

public interface ProjectRepository {
    Project save(Project project);
    Project getById(UUID projectId);
    List<Project> getAll();
}
