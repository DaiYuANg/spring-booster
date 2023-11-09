package org.toolkit.spring.boot.authentication.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import javax.crypto.SecretKey;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.authentication.configuration.properties.JwtConfigProperties;
import org.toolkit.spring.boot.authentication.service.IJwtService;

@Service
@ConditionalOnMissingBean(IJwtService.class)
@Slf4j
public class JwtService implements IJwtService {
	@Resource
	private JwtConfigProperties jwtConfigProperties;

	private String secretKey;

	@PostConstruct
	private void init() {
		log.atDebug().log("Default jwt service check is secret key preset");
		secretKey = Optional.ofNullable(jwtConfigProperties.getSecretKey())
				.orElseGet(() -> SecureUtil.rsa().getPrivateKey().getFormat());
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
				.expiration(DateUtil.date(jwtConfigProperties.getExpiration()))
				.encryptWith(getSigningKey(), enc)
				.compact();
	}

	private @NotNull SecretKey getSigningKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
