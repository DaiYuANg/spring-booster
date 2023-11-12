package org.toolkit.spring.boot.minio.actuator;

import jakarta.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.minio.core.template.MinioTemplate;

@Component
@Endpoint(id = "features")
public class ActuatorEndpoint {

	@Resource
	private ConcurrentMap<String, MinioTemplate> templateConcurrentMap;

	@ReadOperation
	public Map<String, MinioTemplate> features() {
		return templateConcurrentMap;
	}

	@ReadOperation
	public MinioTemplate feature(@Selector String name) {
		return templateConcurrentMap.get(name);
	}

	@DeleteOperation
	public void deleteFeature(@Selector String name) {
		templateConcurrentMap.remove(name);
	}
}
