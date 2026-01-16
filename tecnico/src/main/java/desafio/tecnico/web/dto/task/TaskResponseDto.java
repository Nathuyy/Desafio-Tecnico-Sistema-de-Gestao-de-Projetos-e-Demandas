package desafio.tecnico.web.dto.task;

import java.time.LocalDateTime;
import java.util.UUID;

import desafio.tecnico.domain.enums.tasks.PriorityEnum;
import desafio.tecnico.domain.enums.tasks.StatusEnum;

public record TaskResponseDto(
    UUID id, 
    String title, 
    StatusEnum status, 
    PriorityEnum priority, 
    LocalDateTime dueDate, 
    UUID projectId) {}