package org.kop.framework.spring.boot.starter.groundwork.dict.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@AutoConfiguration
@ComponentScan("org.kop.framework.spring.boot.starter.groundwork.dict.**.*")
//@EnableJpaRepositories("org.kop.framework.spring.boot.starter.groundwork.dict.repos")
@EntityScan({"org.kop.framework.spring.boot.starter.groundwork.dict.entities"})
public class DictAutoConfiguration {
}
