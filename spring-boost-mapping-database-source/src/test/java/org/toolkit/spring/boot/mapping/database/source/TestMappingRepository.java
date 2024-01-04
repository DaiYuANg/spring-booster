/* (C)2023*/
package org.toolkit.spring.boot.mapping.database.source;

import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.assertEquals;

import jakarta.annotation.Resource;
import lombok.val;
import net.datafaker.Faker;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import org.toolkit.spring.boot.mapping.database.source.entity.MappingEntity;
import org.toolkit.spring.boot.mapping.database.source.repository.MappingEntityRepository;

@RunWith(SpringRunner.class)
@Testcontainers
@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@EnableJpaAuditing
public class TestMappingRepository {
    @Container
    private static final MySQLContainer<?> mySQLContainer = new MySQLContainer<>(DockerImageName.parse("mysql:latest"))
            .withUsername("root")
            .withPassword("root")
            .withDatabaseName("mapping");

    @DynamicPropertySource
    static void configureTestProperties(@NotNull DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mySQLContainer::getUsername);
        registry.add("spring.datasource.password", mySQLContainer::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create");
        registry.add("spring.jpa.properties.hibernate.format_sql", () -> true);
        registry.add("logging.level.org.hibernate.type.descriptor.sql", () -> "trace");
        registry.add("logging.level.org.hibernate.SQL", () -> "debug");
    }

    @Resource
    private MappingEntityRepository repository;

    //	@Test
    public void testRepo() {
        val f = new Faker();
        val fakeData = range(0, 1000)
                .mapToObj(i -> new MappingEntity()
                        .setIsDelete(false)
                        .setNaming(f.name().name())
                        .setDescription(f.random().hex())
                        .setCode(f.code().asin())
                        .setType(f.computer().type()))
                .toList();
        repository.saveAllAndFlush(fakeData);
        assertEquals(1000, repository.count());
    }
}
