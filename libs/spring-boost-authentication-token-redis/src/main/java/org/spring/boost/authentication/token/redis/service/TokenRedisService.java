package org.spring.boost.authentication.token.redis.service;

import lombok.RequiredArgsConstructor;
import org.spring.boost.authentication.api.TokenManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;

@RequiredArgsConstructor
public class TokenRedisService implements TokenManager {

  private final RedisTemplate<String, Object> redisTemplate;

  @Override
  public String generateToken(Authentication authentication) {
    return "";
  }

  @Override
  public Authentication parseToken(String token) {
    return null;
  }

  @Override
  public boolean validateToken(String token) {
    return false;
  }

  @Override
  public boolean validateRefreshToken(String refreshToken) {
    return false;
  }

  @Override
  public String refreshToken(String token) {
    return "";
  }
}
