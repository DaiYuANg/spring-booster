/* (C)2023*/
package org.spring.boost.mapping.database.source.configuration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(MappingDatabaseSourceProperties.class)
@RequiredArgsConstructor
public class MappingDatabaseSourceAutoConfiguration {

    private static final int cpuCore = Runtime.getRuntime().availableProcessors();

    private final MappingDatabaseSourceProperties mappingDatabaseSourceProperties;

    private final ApplicationContext context;

    @PostConstruct
    public void init() {
        log.atInfo().log("mapping datasource source auto config executing");
    }
}
