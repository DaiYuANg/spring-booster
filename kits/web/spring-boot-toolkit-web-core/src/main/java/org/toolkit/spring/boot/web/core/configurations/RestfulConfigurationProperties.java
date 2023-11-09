package org.toolkit.spring.boot.web.core.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.toolkit.spring.boot.web.core.structure.Response;

@ConfigurationProperties(prefix = "restful")
@Getter
@Setter
public class RestfulConfigurationProperties {
	private Class<?> returnResult = Response.class;
}
