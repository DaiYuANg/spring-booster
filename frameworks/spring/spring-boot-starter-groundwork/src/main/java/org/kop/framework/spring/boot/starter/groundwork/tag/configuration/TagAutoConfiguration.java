package org.kop.framework.spring.boot.starter.groundwork.tag.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@Slf4j
@ComponentScan("org.kop.framework.spring.boot.starter.groundwork.tag.**.*")
//@EnableJpaRepositories("org.kop.framework.spring.boot.starter.groundwork.dict.repos")
@EntityScan({"org.kop.framework.spring.boot.starter.groundwork.tag.entities"})
public class TagAutoConfiguration {
}
