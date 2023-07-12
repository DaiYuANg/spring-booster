package org.toolkit4j.framework.spring.starter.authentication;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.toolkit4j.framework.spring.starter.authentication.configurations.AuthenticationConfiguration;

@SpringBootTest(classes = {SpringBootApplication.class, AuthenticationConfiguration.class,
        LocalSessionFactoryBean.class},
        properties = {"spring.datasource.url=jdbc:tc:postgresql:latest:///databasename",
                "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect",
                "spring.jpa.database=postgresql"
        }
)
@RunWith(SpringRunner.class)
@Slf4j
class AuthTest {

//    @ClassRule
//    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:11.1")
//            .withDatabaseName("integration-tests-db")
//            .withUsername("sa")
//            .withPassword("sa");
//    @ClassRule
//
//    static GenericContainer<?> redis = new GenericContainer<>(DockerImageName.parse("redis:3-alpine"))
//            .withExposedPorts(6379);
//
//    @BeforeClass
//    public static void before() {
//        System.setProperty("spring.datasource.url", postgreSQLContainer.getJdbcUrl());
//        System.setProperty("spring.datasource.driver-class-name", postgreSQLContainer.getDriverClassName());
//        System.setProperty("spring.datasource.username", postgreSQLContainer.getUsername());
//        System.setProperty("spring.datasource.password", postgreSQLContainer.getPassword());
//    }
//
//    @Resource
//    private IUserServices<UserEntity> userEntityIUserServices;
//
//    @DynamicPropertySource
//    static void redisProperties(@NotNull DynamicPropertyRegistry registry) {
//        redis.start();
//        registry.add("spring.redis.host", redis::getHost);
//        registry.add("spring.redis.port", redis::getFirstMappedPort);
//    }
//
//    @Test
//    void init() {
//        System.err.println(123);
//    }
//
//    @Test
//    void onShutdown() {
//    }
}