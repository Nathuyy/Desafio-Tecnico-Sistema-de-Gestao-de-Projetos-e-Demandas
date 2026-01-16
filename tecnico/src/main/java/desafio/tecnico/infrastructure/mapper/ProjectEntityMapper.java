package desafio.tecnico.infrastructure.mapper;

import desafio.tecnico.domain.entities.Project;
import desafio.tecnico.infrastructure.persistence.entities.ProjectEntity;

public class ProjectEntityMapper {

    public Project toDomain(ProjectEntity project) {
        return new Project.Builder(project.getName(), project.getStartDate()).id(project.getId()).description(project.getDescription()).endDate(project.getEndDate()).build();
    }

    public ProjectEntity toEntity(Project project) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(project.getId());
        projectEntity.setName(project.getName());
        projectEntity.setStartDate(project.getStartDate());
        projectEntity.setDescription(project.getDescription());
        projectEntity.setEndDate(project.getEndDate());
        return projectEntity;
    }
}
