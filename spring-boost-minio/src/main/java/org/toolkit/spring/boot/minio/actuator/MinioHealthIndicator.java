/* (C)2023*/
package org.toolkit.spring.boot.minio.actuator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MinioHealthIndicator implements HealthIndicator {
	@Override
	public Health health() {
		return new Health.Builder().build();
	}
}
