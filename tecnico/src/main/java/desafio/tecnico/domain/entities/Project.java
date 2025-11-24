package desafio.tecnico.domain.entities;

import java.util.Date;
import java.util.UUID;

import desafio.tecnico.domain.exception.DomainException;

public class Project {
    private UUID id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;

    public Project(Builder build){
        this.validateProjectDates(build.startDate, build.endDate);
        this.validateProjectName(build.name);
        this.id = build.id;
        this.name = build.name;
        this.description = build.description;
        this.startDate = build.startDate;
        this.endDate = build.endDate;
    }

    /*
     * Criei um builder pois garante que todas as validações ocorram no construtor antes do objeto existir
     * se a validação falhar o objeto nem vai existir
     */
    public static class Builder {
        private UUID id;
        private String name;
        private String description = null;
        private Date startDate;
        private Date endDate = null;

        public Builder(String name, Date startDate){
            this.name = name;
            this.startDate = startDate;
        }

        public Builder id(UUID id){
            this.id = id;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder endDate(Date endDate){
            this.endDate = endDate;
            return this;
        }

        public Project build(){
            return new Project(this);
        }
        
    }

    private void validateProjectDates(Date startDate, Date endDate){
        if (startDate == null) {
            throw new DomainException("A start date is required");
        }

        if (endDate == null) {
            return;
        }

        if (startDate.after(endDate)) {
            throw new DomainException("The start date cannot be after the end date");
  
        }
    }

    private void validateProjectName(String name){
        if ( name.length() < 3) {
            throw new DomainException("Project name is invalid");   
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
}
