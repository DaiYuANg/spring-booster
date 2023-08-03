package org.toolkit.spring.boot.starter.dict.configuration;

import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("org.toolkit.spring.boot.starter.dict.**.*")
@EnableJpaRepositories("org.toolkit.spring.boot.starter.dict.**.*")
@EntityScan({"org.toolkit.spring.boot.starter.dict.**.*"})
@EnableConfigurationProperties(DictConfigurationProperties.class)
public class DictAutoConfiguration {
	@Resource
	private DictConfigurationProperties dictConfigurationProperties;

	@Bean
	@ConditionalOnMissingBean(value = {Gson.class})
	public Gson gson() {
		return new Gson();
	}
}
