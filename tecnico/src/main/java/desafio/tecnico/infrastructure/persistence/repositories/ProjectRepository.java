package desafio.tecnico.infrastructure.persistence.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import desafio.tecnico.infrastructure.persistence.entities.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, UUID> {
    
}
