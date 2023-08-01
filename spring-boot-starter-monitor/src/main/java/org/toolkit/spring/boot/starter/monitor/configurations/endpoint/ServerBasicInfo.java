package org.toolkit.spring.boot.starter.monitor.configurations.endpoint;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class ServerBasicInfo {
	private final String host;
	private final String port;
	private final String contextPath;

	public String fullAccessPath() {
		return "http://%s:%s%s".formatted(host, port, contextPath);
	}

	public String swaggerUI() {
		return "%sswagger-ui.html".formatted(fullAccessPath());
	}
}
