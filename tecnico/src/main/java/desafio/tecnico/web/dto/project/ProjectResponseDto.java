package desafio.tecnico.web.dto.project;

import java.util.Date;
import java.util.UUID;

public record ProjectResponseDto(
    UUID id,
    String name,
    String description,
    Date startDate,
    Date endDate
) {}
