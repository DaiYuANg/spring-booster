package org.toolkit.spring.boot.authentication.funcational;

import cn.hutool.captcha.AbstractCaptcha;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.core.util.RandomUtil;

@Slf4j
@Component
public class CaptchaGenerator {
	private final ExpiringMap<UUID, AbstractCaptcha> captchaExpiringMap =
			ExpiringMap.builder().variableExpiration().build();

	public String generateCaptcha(UUID uuid) {
		if (Objects.isNull(uuid)) throw new RuntimeException("params is empty");
		log.info("generate captcha:{}", uuid);
		val captcha = randomCaptcha().orElseThrow();
		captchaExpiringMap.put(uuid, captcha, ExpirationPolicy.ACCESSED, 30, TimeUnit.SECONDS);
		return captcha.getImageBase64Data();
	}

	@Contract(pure = true)
	private @NotNull Optional<AbstractCaptcha> randomCaptcha() {
		return Stream.of(
						CaptchaUtil.createCircleCaptcha(200, 100),
						CaptchaUtil.createGifCaptcha(200, 100),
						CaptchaUtil.createLineCaptcha(200, 100),
						CaptchaUtil.createShearCaptcha(200, 100))
				.skip(RandomUtil.randomInt(0, 4))
				.findAny();
	}
}
