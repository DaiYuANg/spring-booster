package org.toolkit.spring.boot.authentication.service;

import io.jsonwebtoken.Claims;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {
	String generateToken(Map<String, Object> extraClaims, @NotNull UserDetails userDetails);

	Claims extractAllClaims(String token);

	String extractUsername(String token);

	String generateToken(UserDetails userDetails);
}
