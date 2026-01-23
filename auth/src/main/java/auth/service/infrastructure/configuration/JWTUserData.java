package auth.service.infrastructure.configuration;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email) {
    
}
