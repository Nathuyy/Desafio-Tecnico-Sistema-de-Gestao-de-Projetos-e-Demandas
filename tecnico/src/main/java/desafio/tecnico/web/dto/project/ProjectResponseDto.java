package desafio.tecnico.web.dto.project;

import java.time.OffsetDateTime;
import java.util.UUID;

public record ProjectResponseDto(
    UUID id,
    String name,
    String description,
    OffsetDateTime startDate,
    OffsetDateTime endDate
) {}
