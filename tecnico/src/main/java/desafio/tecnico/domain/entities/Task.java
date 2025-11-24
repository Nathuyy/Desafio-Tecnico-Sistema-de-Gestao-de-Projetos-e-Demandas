package desafio.tecnico.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import desafio.tecnico.domain.enums.tasks.PriorityEnum;
import desafio.tecnico.domain.enums.tasks.StatusEnum;
import desafio.tecnico.domain.exception.DomainException;

public class Task {
    private UUID id;
    private String title;
    private StatusEnum status;
    private PriorityEnum priority;
    private LocalDateTime dueDate;
    private UUID projectId;

    public Task(Builder build){
        this.validateTaskTitle(build.title);
        this.validateTaskDueDate(build.dueDate);
        this.validateTaskProjectId(build.projectId);
        this.id = build.id;
        this.status = build.status;
        this.priority = build.priority;
        this.dueDate = build.dueDate;
        this.projectId = build.projectId;
    }

    public static class Builder {
        private UUID id;
        private String title;
        private LocalDateTime dueDate;
        private UUID projectId;
        private StatusEnum status;
        private PriorityEnum priority;

        public Builder(String title, LocalDateTime dueDate, UUID projectId) {
            this.title = title;
            this.dueDate = dueDate;
            this.projectId = projectId;
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder status(StatusEnum status) {
            this.status = status;
            return this;
        }

        public Builder priority(PriorityEnum priority) {
            this.priority = priority;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }

    private void validateTaskTitle(String title){
        if (title == null || title.isBlank()) {
            throw new DomainException("Title is required");
        }

        if ( title.length() < 5 || title.length() > 150 ) {
            throw new DomainException("The title must have more than 5 letters and less than 150 letters.");

        }
    }

    private void validateTaskDueDate(LocalDateTime dueDate){
        if (dueDate == null) {
            throw new DomainException("Duedate is required");
        }

        if (dueDate.isBefore(LocalDateTime.now())) {
            throw new DomainException("The due date must not have passed.");
        }
    }
    
    private void validateTaskProjectId(UUID projectId){
        if (projectId == null) {
            throw new DomainException("Project id is required");
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

}
