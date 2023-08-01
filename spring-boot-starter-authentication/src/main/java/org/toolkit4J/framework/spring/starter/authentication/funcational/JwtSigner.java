package org.toolkit4J.framework.spring.starter.authentication.funcational;

import cn.hutool.crypto.asymmetric.RSA;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;
import org.toolkit4J.framework.spring.starter.authentication.configurations.AuthenticationProperties;
import org.toolkit4J.framework.spring.starter.authentication.entities.UserEntity;

@Component
@Slf4j
@Getter
public class JwtSigner {

	private final PublicKey publicKey;

	private final PrivateKey privateKey;

	@Resource
	private AuthenticationProperties properties;

	private Algorithm algorithm;

	@PostConstruct
	public void init() {
		log.info("jwt signer init");
	}

	public JwtSigner() {
		RSA rsa = new RSA();
		publicKey = rsa.getPublicKey();
		privateKey = rsa.getPrivateKey();
	}

	public JwtSigner(PublicKey publicKey, PrivateKey privateKey) {
		this.privateKey = privateKey;
		this.publicKey = publicKey;
	}

	public String sign(UserEntity user) {
		Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) publicKey, (RSAPrivateKey) privateKey);
		return JWT.create().withIssuer("auth0").sign(algorithm);
	}

	public boolean verify(String token) {
		JWTVerifier verifier = JWT.require(Algorithm.RSA256((RSAPublicKey) publicKey, (RSAPrivateKey) privateKey))
				// specify an specific claim validations
				.withIssuer("auth0")
				// reusable verifier instance
				.build();

		val decodedJWT = verifier.verify(token);
		return true;
	}
}
