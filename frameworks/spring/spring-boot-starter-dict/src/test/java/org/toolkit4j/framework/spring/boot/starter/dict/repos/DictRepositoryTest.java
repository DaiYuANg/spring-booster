package org.toolkit4j.framework.spring.boot.starter.dict.repos;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.toolkit4j.framework.spring.boot.starter.dict.configuration.DictAutoConfiguration;
import org.toolkit4j.framework.spring.boot.starter.dict.entities.Dict;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
        classes = {SpringBootApplication.class, DictAutoConfiguration.class, LocalSessionFactoryBean.class},
        properties = {
                "spring.datasource.url=jdbc:tc:postgresql:latest:///databasename",
                "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect",
                "spring.jpa.database=postgresql"
        })
@RunWith(SpringRunner.class)
@Slf4j
class DictRepositoryTest {

    @Resource
    private DictRepository dictRepository;

    @Test
    void findByDictCodeIgnoreCase() {
        dictRepository.save(new Dict().setDictCode("test"));
    }
}