/* (C)2023*/
package org.toolkit.spring.boot.mapping.database.source.configuration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(MappingDatabaseSourceProperties.class)
@EntityScan("org.toolkit.spring.boot.mapping.database.source.entity")
@EnableJpaRepositories("org.toolkit.spring.boot.mapping.database.source.repository")
@ComponentScan("org.toolkit.spring.boot.mapping.database.source.**.*")
public class MappingDatabaseSourceAutoConfiguration {

	private static final int cpuCore = Runtime.getRuntime().availableProcessors();

	@Resource
	private MappingDatabaseSourceProperties mappingDatabaseSourceProperties;

	@Resource
	private ApplicationContext context;

	@PostConstruct
	public void init() {
		log.atInfo().log("mapping datasource source auto config executing");
	}

	//    @Bean(name = "DataSourceMapOfMappingDatabaseSource")
	//    public ConcurrentMap<String, DataSource> dataSourceMap() {
	//        Map<String, DataSourceProperties> dataSourcePropertiesMap =
	// context.getBeansOfType(DataSourceProperties.class);
	//        return dataSourcePropertiesMap.keySet().stream()
	//                .map(dataSourceBeanName -> {
	//                    val dataSource = context.getBean(dataSourceBeanName, DataSource.class);
	//                    return Map.entry(dataSourceBeanName, dataSource);
	//                })
	//                .distinct()
	//                .collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
	//    }
}
