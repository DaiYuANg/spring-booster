package org.kop.framework.spring.boot.starter.groundwork.tag.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@AutoConfiguration
@Slf4j
@ComponentScan("org.kop.framework.spring.boot.starter.groundwork.tag.**.*")
//@EnableJpaRepositories("org.kop.framework.spring.boot.starter.groundwork.dict.repos")
@EntityScan({"org.kop.framework.spring.boot.starter.groundwork.tag.entities"})
public class TagAutoConfiguration {
}
