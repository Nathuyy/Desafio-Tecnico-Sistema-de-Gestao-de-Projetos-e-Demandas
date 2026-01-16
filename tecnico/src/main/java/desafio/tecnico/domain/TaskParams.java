package desafio.tecnico.domain;

import desafio.tecnico.domain.enums.tasks.PriorityEnum;
import desafio.tecnico.domain.enums.tasks.StatusEnum;

public class TaskParams {
    private StatusEnum status;
    private PriorityEnum priority;

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

}