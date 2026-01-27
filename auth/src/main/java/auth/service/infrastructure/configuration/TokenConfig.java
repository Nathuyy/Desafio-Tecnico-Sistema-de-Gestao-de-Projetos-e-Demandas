package auth.service.infrastructure.configuration;

import java.time.Instant;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import auth.service.infrastructure.persistence.entities.User;

@Component
public class TokenConfig {
    private String secrete = "secret"; //ideal seria colocar dentro do aplication.props ou variavel dentro do so

    Algorithm algorithm = Algorithm.HMAC256(secrete);


    public String generateToken(User user) {
        return JWT.create()
                .withClaim("userId", user.getId())
                .withSubject(user.getEmail())
                .withExpiresAt(Instant.now().plusSeconds(3600))
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }


    public Optional<JWTUserData> validateToken(String token) {
        DecodedJWT decode = JWT.require(this.algorithm).build().verify(token);
        return Optional.of(JWTUserData.builder()
                    .userId(decode.getClaim("userId").asLong())
                    .email(decode.getSubject())
                    .build());
    }
}
