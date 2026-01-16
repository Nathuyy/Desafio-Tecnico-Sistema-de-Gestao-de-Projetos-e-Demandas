package desafio.tecnico.web.dto.project;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProjectRequestDto(
    @NotBlank(message = "Name is required")
    String name,
    String description,
    @NotNull(message = "Start date is required")
    OffsetDateTime startDate,
    OffsetDateTime endDate
) {}
