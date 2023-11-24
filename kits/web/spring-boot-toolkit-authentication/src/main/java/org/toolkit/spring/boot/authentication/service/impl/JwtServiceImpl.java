package org.toolkit.spring.boot.authentication.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.AeadAlgorithm;
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
import org.springframework.security.core.userdetails.UserDetails;
import org.toolkit.spring.boot.authentication.configuration.properties.JwtConfigProperties;
import org.toolkit.spring.boot.authentication.service.IJwtService;

@Slf4j
@RequiredArgsConstructor
public class JwtServiceImpl implements IJwtService {
    private final JwtConfigProperties jwtConfigProperties;

    private String secretKey;

    private final static SecretKey key = Jwts.SIG.HS256.key().build();

    @PostConstruct
    private void init() {
        log.atDebug().log("Default jwt service check is secret key preset");
        secretKey = Optional.ofNullable(jwtConfigProperties.getSecretKey())
                .orElseGet(() -> SecureUtil.aes().getCipher().toString());
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
                .expiration(DateUtil.endOfDay(new Date()))
                .signWith(key)
//				.encryptWith(getSigningKey(), enc)
                .compact();
    }

    public <T> T extractClaim(String token, @NotNull Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    @Override
    public Claims extractAllClaims(String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
//		return Jwts.parser()
//				.unsecured()
//				.verifyWith(getSigningKey())
////				.decryptWith(getSigningKey())
//				.build()
//				.parseSignedClaims(token)
//				.getPayload();
    }

    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    private @NotNull SecretKey getSigningKey() {
        //        System.err.println(secretKey);
        //        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        //        return Keys.hmacShaKeyFor(keyBytes);
//        return .build();
        return null;
    }

    public static void main(String[] args) {
        SecretKey key = Jwts.SIG.HS256.key().build();

        String token = Jwts.builder().claims(new HashMap<>()).subject("test")
                .issuedAt(new Date(System.currentTimeMillis())).signWith(key).compact();
        System.err.println(token);
        Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
    }
}
