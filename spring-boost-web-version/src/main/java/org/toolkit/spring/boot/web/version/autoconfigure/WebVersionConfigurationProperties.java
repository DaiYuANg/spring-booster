/* (C)2023*/
package org.toolkit.spring.boot.web.version.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.toolkit.spring.boot.web.version.base.VersionDetectType;

@ConfigurationProperties(prefix = "spring.web.version")
@Getter
@Setter
@ToString
public class WebVersionConfigurationProperties {

	private VersionDetectType detectType = VersionDetectType.HEADER;

	private String headerField = "Version";

	private String pathPrefix = "v";
}
