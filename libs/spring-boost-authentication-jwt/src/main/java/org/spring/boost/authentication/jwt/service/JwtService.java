/* (C)2023*/
package org.spring.boost.authentication.jwt.service;

import io.jsonwebtoken.Claims;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author daiyuang
 * IJwtService jwt service behaviour rule
 */
public interface JwtService {
    String generateToken(Map<String, Object> extraClaims, @NotNull UserDetails userDetails);

    Claims extractAllClaims(String token);

    String extractUsername(String token);

    String generateToken(UserDetails userDetails);

  String generateToken(Authentication authentication);
}
