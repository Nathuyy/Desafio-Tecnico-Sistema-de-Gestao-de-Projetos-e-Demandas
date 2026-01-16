package desafio.tecnico.infrastructure.mapper;

import desafio.tecnico.domain.entities.Task;
import desafio.tecnico.infrastructure.persistence.entities.TaskEntity;

public class TaskEntityMapper {

    public Task toDomain(TaskEntity task){
        return new Task.Builder(task.getTitle(), task.getDueDate(), task.getProjectId()).id(task.getId()).status(task.getStatus()).priority(task.getPriority()).build();    
    }

    public TaskEntity toEntity(Task task){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(task.getId());
        taskEntity.setTitle(task.getTitle());
        taskEntity.setDueDate(task.getDueDate());
        taskEntity.setPriority(task.getPriority());
        taskEntity.setStatus(task.getStatus());
        taskEntity.setProjectId(task.getProjectId());
        return taskEntity;
    }
    
}
