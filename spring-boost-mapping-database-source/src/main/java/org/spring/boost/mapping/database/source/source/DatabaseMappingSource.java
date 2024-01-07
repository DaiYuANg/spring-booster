/* (C)2023*/
package org.spring.boost.mapping.database.source.source;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.mapping.core.base.MappingSource;

@Component
@Slf4j
public class DatabaseMappingSource implements MappingSource {
    @Override
    public Optional<Object> getLabel(String key, String value) {
        return Optional.empty();
    }

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
