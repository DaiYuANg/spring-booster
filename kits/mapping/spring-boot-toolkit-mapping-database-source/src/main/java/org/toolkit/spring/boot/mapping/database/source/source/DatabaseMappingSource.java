package org.toolkit.spring.boot.mapping.database.source.source;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.mapping.core.base.MappingSource;

@Component
@Slf4j
public class DatabaseMappingSource implements MappingSource {

	//	@Resource(name = "DataSourceMapOfMappingDatabaseSource")
	//	private ConcurrentMap<String, DataSource> dataSourceMap;

	//	@SneakyThrows
	//	@PostConstruct
	//	public void init() {
	//		for (DataSource value : dataSourceMap.values()) {
	//			val metadata = value.getConnection().getMetaData();
	//		}
	//	}
}
