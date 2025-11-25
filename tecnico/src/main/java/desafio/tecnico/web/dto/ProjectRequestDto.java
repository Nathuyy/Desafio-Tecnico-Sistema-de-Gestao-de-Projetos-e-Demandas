package desafio.tecnico.web.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProjectRequestDto(
    @NotBlank(message = "Name is required")
    String name,
    String description,
    @NotNull(message = "Start date is required")
    Date startDate,
    Date endDate
) {}
