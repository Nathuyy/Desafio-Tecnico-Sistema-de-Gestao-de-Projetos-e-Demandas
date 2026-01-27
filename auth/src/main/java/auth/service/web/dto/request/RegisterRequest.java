package auth.service.web.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record RegisterRequest(
    @NotEmpty(message = "name is required") String name, 
    @NotEmpty(message = "Email is required") String email, 
    @NotEmpty(message = "Password is required") String password
) {
}