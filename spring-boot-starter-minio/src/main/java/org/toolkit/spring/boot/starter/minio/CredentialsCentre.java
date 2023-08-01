package org.toolkit.spring.boot.starter.minio;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentParser;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CopyOnWriteArraySet;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.jodah.expiringmap.ExpiringMap;
import org.jetbrains.annotations.NotNull;

@Slf4j
public class CredentialsCentre {
	@Resource
	private MinioConfigurationProperties configurationProperties;

	private final ExpiringMap<String, String> credentialStore =
			ExpiringMap.builder().variableExpiration().build();

	private final ExpiringMap<String, RSA> encryptStore =
			ExpiringMap.builder().variableExpiration().build();

	private final CopyOnWriteArraySet<String> randomUUID = new CopyOnWriteArraySet<>();

	public String createCredential(String minioInstance, @NotNull HttpServletRequest request) {
		IMinioTemplate template = SpringUtil.getBean(minioInstance);
		val random = IdUtil.randomUUID();
		val rsa = new RSA();
		val accessesKey = random + ":" + uniqueDevice(UserAgentParser.parse(request.getHeader("user-agent")), template);
		val after = StrUtil.str(
				rsa.encrypt(accessesKey.getBytes(StandardCharsets.UTF_8), KeyType.PublicKey), StandardCharsets.UTF_8);
		credentialStore.put(
				minioInstance,
				after,
				configurationProperties.getCredentialExpire(),
				configurationProperties.getCredentialUnit());
		encryptStore.put(after, rsa);
		randomUUID.add(random);
		return accessesKey;
	}

	private int uniqueDevice(@NotNull UserAgent userAgent, @NotNull IMinioTemplate template) {
		return Math.abs(userAgent.getOs().getName().hashCode()
				+ userAgent.getEngineVersion().hashCode()
				+ userAgent.getEngine().getName().hashCode()
				+ userAgent.getPlatform().getName().hashCode()
				+ userAgent.getOsVersion().hashCode()
				+ userAgent.getVersion().hashCode()
				+ template.hashCode()
				+ this.hashCode());
	}

	public boolean verifyCredential(String minioInstance, HttpServletRequest request, String credential) {
		if (!encryptStore.containsKey(credential)) return false;
		IMinioTemplate template = SpringUtil.getBean(minioInstance);
		uniqueDevice(UserAgentParser.parse(request.getHeader("user-agent")), template);
		if (randomUUID.contains(minioInstance)) return false;
		return true;
	}
}
