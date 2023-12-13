package org.toolkit.spring.boot.web.core.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.toolkit.spring.boot.web.core.structure.Response;

@ConfigurationProperties(prefix = "spring")
@Getter
@Setter
public class WebCoreConfigurationProperties {
	/**
	 * Global return value struct
	 */
	private Class<?> returnResult = ResponseEntity.class;
}
