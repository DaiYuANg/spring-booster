package org.toolkit.spring.boot.mapping.database.source.configuration;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(MappingDatabaseSourceProperties.class)
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

	@Bean(name = "DataSourceMapOfMappingDatabaseSource")
	public ConcurrentMap<String, DataSource> dataSourceMap() {
		Map<String, DataSourceProperties> dataSourcePropertiesMap = context.getBeansOfType(DataSourceProperties.class);
		return dataSourcePropertiesMap.keySet().stream()
				.map(dataSourceBeanName -> {
					val dataSource = context.getBean(dataSourceBeanName, DataSource.class);
					return Map.entry(dataSourceBeanName, dataSource);
				})
				.distinct()
				.collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	@Bean(name = "ThreadPoolExecutorOfMapping")
	public ThreadPoolExecutor threadPoolExecutorOfMapping() {
		return new ThreadPoolExecutor(
				cpuCore * 2 + 1,
				cpuCore * 2 * 2 + 1,
				1,
				TimeUnit.MINUTES,
				new ArrayBlockingQueue<>(cpuCore * 2 * 2 + 1),
				new ThreadFactoryBuilder()
						.setNameFormat(mappingDatabaseSourceProperties.getThreadPoolPrefix() + "-%d")
						.setDaemon(false)
						.build(),
				new ThreadPoolExecutor.CallerRunsPolicy());
	}
}
