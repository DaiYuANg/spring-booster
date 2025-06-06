/* (C)2023*/
package org.spring.boost.authentication.jwt.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import javax.crypto.SecretKey;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.jwt.autoconfigure.JwtConfigProperties;
import org.spring.boost.authentication.jwt.service.JwtService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

@Slf4j
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {
  private final JwtConfigProperties jwtConfigProperties;

  private String secretKey;

  private static final SecretKey key = Jwts.SIG.HS256.key().build();

  @PostConstruct
  private void init() {
    log.atDebug().log("Default jwt service check is secret key preset");
    //		secretKey = Optional.ofNullable(jwtConfigProperties.getSecretKey())
    //				.orElseGet(() -> SecureUtil.aes().getCipher().toString());
  }

  @Override
  public String generateToken(Map<String, Object> extraClaims, @NotNull UserDetails userDetails) {
    val enc = Optional.ofNullable(jwtConfigProperties.getEncryptArithmetic())
      .map(a -> Jwts.ENC.get().forKey(a))
      .orElse(Jwts.ENC.A256GCM);
    return Jwts.builder()
      .claims(extraClaims)
      .subject(userDetails.getUsername())
      .issuedAt(new Date(System.currentTimeMillis()))
      .expiration(new Date(System.currentTimeMillis() + 3600 * 6 * 6))
      .signWith(key)
      .compact();
  }

  public <T> T extractClaim(String token, @NotNull Function<Claims, T> claimsResolver) {
    val claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  @Override
  public Claims extractAllClaims(String token) {
    return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
  }

  @Override
  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  @Override
  public String generateToken(UserDetails userDetails) {
    return generateToken(new HashMap<>(), userDetails);
  }

  @Override
  public String generateToken(Authentication authentication) {
//    return generateToken(new HashMap<>(), userDetails);
    return "null";
  }
}
