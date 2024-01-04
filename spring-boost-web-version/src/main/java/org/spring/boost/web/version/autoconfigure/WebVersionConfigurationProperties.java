/* (C)2023*/
package org.spring.boost.web.version.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.spring.boost.web.version.base.VersionDetectType;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.web.version")
@Getter
@Setter
@ToString
public class WebVersionConfigurationProperties {

	private VersionDetectType detectType = VersionDetectType.HEADER;

	private String headerField = "Version";

	private String pathPrefix = "v";
}
