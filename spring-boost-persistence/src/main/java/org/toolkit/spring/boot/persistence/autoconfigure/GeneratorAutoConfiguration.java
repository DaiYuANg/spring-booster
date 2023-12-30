/* (C)2023*/
package org.toolkit.spring.boot.persistence.autoconfigure;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(GeneratorConfigurationProperties.class)
@EnableTransactionManagement
@AutoConfigureBefore({HibernateJpaAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class})
public class GeneratorAutoConfiguration {
	@PostConstruct
	public void init() {
		log.info("Persistence Generator Auto config executing");
	}
}
