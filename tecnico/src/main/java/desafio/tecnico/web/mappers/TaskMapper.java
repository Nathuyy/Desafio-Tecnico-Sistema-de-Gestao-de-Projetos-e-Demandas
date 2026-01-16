package desafio.tecnico.web.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import desafio.tecnico.domain.entities.Task;
import desafio.tecnico.infrastructure.persistence.entities.TaskEntity;
import desafio.tecnico.web.dto.task.TaskRequestDto;
import desafio.tecnico.web.dto.task.TaskResponseDto;

@Component
public class TaskMapper {
    public Task toDomain(TaskEntity task){
        return new Task.Builder(task.getTitle(), task.getDueDate(), task.getProjectId()).id(task.getId()).status(task.getStatus()).priority(task.getPriority()).build();    
    }

    public Task toDomain(TaskRequestDto task){
        return new Task.Builder(task.title(), task.dueDate(), task.projectId()).status(task.status()).priority(task.priority()).build();    
    }

    public TaskEntity toEntity(Task task) {
        TaskEntity entity = new TaskEntity();
        entity.setId(task.getId());
        entity.setTitle(task.getTitle());
        entity.setStatus(task.getStatus());
        entity.setPriority(task.getPriority());
        entity.setDueDate(task.getDueDate());
        entity.setProjectId(task.getProjectId());

        return entity;
    } 

    public TaskResponseDto toResponse(Task task){
        return new TaskResponseDto(
            task.getId(), task.getTitle(), task.getStatus(), task.getPriority(), task.getDueDate(), task.getProjectId()
        );
    }

    public List<TaskResponseDto> toResponseList(List<Task> tasks){
        return tasks.stream()
            .map(this::toResponse)
            .toList();
    }
}
