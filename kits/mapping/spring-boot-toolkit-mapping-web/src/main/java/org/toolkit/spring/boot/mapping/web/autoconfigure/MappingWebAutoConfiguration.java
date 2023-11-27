package org.toolkit.spring.boot.mapping.web.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.ByteBuddy;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(MappingWebConfigurationProperties.class)
@EnableAspectJAutoProxy
@ComponentScan("org.toolkit.spring.boot.mapping.web.**.*")
public class MappingWebAutoConfiguration {

	@Bean
	public ByteBuddy byteBuddy() {
		return new ByteBuddy();
	}
}
