package org.toolkit.spring.boot.starter.persistence.configuration;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.sql.DataSource;

@AutoConfiguration
@EnableConfigurationProperties(PersistenceConfigurationProperties.class)
@Slf4j
@EnableJpaAuditing
@AutoConfigureBefore({HibernateJpaAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class})
public class PersistenceAutoConfiguration {

	@PostConstruct
	public void init() {
		log.info("Persistence auto config executing");
	}

	@Primary
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource userDataSource() {
		return DataSourceBuilder.create().build();
	}
}
