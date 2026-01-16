package desafio.tecnico.web.dto.task;

import java.time.LocalDateTime;
import java.util.UUID;

import desafio.tecnico.domain.enums.tasks.PriorityEnum;
import desafio.tecnico.domain.enums.tasks.StatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskRequestDto(
    @NotBlank(message = "Title is required")
    String title,
    StatusEnum status,
    @NotNull(message = "Due date is required")
    LocalDateTime dueDate,
    PriorityEnum priority,
    @NotNull(message = "Task must be assigned to a project")
    UUID projectId
) {}
