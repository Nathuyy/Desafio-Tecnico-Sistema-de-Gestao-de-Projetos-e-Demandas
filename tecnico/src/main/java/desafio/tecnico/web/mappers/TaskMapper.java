package desafio.tecnico.web.mappers;

import org.springframework.stereotype.Component;

import desafio.tecnico.domain.entities.Task;
import desafio.tecnico.infrastructure.persistence.entities.TaskEntity;

@Component
public class TaskMapper {
    public Task toDomain(TaskEntity task){
        return new Task.Builder(task.getTitle(), task.getDueDate(), task.getProjectId()).id(task.getId()).status(task.getStatus()).priority(task.getPriority()).build();    
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
}
