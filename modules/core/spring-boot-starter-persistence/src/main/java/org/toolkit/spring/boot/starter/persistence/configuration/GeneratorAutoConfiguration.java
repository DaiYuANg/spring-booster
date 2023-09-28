package org.toolkit.spring.boot.starter.persistence.configuration;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.starter.persistence.base.IGenerator;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(GeneratorConfigurationProperties.class)
@AutoConfigureBefore({HibernateJpaAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class})
public class GeneratorAutoConfiguration {
	@PostConstruct
	public void init() {
		log.info("Persistence Generator Auto config executing");
	}

	@Bean
	@ConditionalOnBean()
	public IGenerator iGenerator() {

		return null;
	}
}
