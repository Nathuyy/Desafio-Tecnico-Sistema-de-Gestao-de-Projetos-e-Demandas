package desafio.tecnico.web.mappers;

import java.util.List;

import desafio.tecnico.domain.entities.Project;
import desafio.tecnico.infrastructure.persistence.entities.ProjectEntity;
import desafio.tecnico.web.dto.project.ProjectRequestDto;
import desafio.tecnico.web.dto.project.ProjectResponseDto;

public class ProjectMapper {
    public Project toDomain(ProjectEntity project){
        return new Project.Builder(project.getName(), project.getStartDate()).id(project.getId()).description(project.getDescription()).endDate(project.getEndDate()).build();
    }

    public Project toDomain(ProjectRequestDto requestDto) {
        return new Project.Builder(requestDto.name(), requestDto.startDate()).description(requestDto.description()).endDate(requestDto.endDate()).build();
    }

    public ProjectResponseDto toResponse(Project project) {
        return new ProjectResponseDto(
            project.getId(),
            project.getName(),
            project.getDescription(),
            project.getStartDate(),
            project.getEndDate()
        );
    }

    public List<ProjectResponseDto> toResponseList(List<Project> projects) {
        return projects.stream()
                .map(this::toResponse)
                .toList();
    }

}


