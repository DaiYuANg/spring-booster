package org.kop.framework.spring.starter.authentication;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.kop.framework.spring.starter.authentication.configurations.AuthenticationConfiguration;
import org.kop.framework.spring.starter.authentication.entities.UserEntity;
import org.kop.framework.spring.starter.authentication.services.IUserServices;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.GenericContainer;

import java.util.concurrent.CompletableFuture;

@SpringBootTest(classes = {SpringBootApplication.class, AuthenticationConfiguration.class, LocalSessionFactoryBean.class})
@TestPropertySource
@RunWith(SpringRunner.class)
@Slf4j
class AuthTest {

    static {
        try (val redis = new GenericContainer<>("redis:5.0.3-alpine")) {
            redis.withExposedPorts(6379);
            CompletableFuture.runAsync(redis::start);
        }
    }

    @ClassRule
//    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:11.1")
//            .withDatabaseName("integration-tests-db")
//            .withUsername("sa")
//            .withPassword("sa");
//    static {
//        try (val mysql = new GenericContainer<>(DockerImageName.parse("mysql:latest"))){
//            mysql.withExposedPorts(3306);
//            System.setProperty("spring.redis.host", redis.getHost());
//            System.setProperty("spring.redis.port", redis.getMappedPort(6379).toString());
//            mysql.start();
//        }
//    }
    @Resource
    private IUserServices<UserEntity> userEntityIUserServices;

    @Test
    void init() {
        System.err.println(123);
    }

    @Test
    void onShutdown() {
    }
}