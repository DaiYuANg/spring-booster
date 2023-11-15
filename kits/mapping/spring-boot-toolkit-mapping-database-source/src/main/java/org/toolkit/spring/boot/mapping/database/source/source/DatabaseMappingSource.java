package org.toolkit.spring.boot.mapping.database.source.source;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.mapping.core.base.MappingSource;

import javax.sql.DataSource;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

@Component
@Slf4j
public class DatabaseMappingSource implements MappingSource {

    @Resource(name = "DataSourceMapOfMappingDatabaseSource")
    private ConcurrentMap<String, DataSource> dataSourceMap;

    @SneakyThrows
    @PostConstruct
    public void init() {
        for (DataSource value : dataSourceMap.values()) {
            val metadata = value.getConnection().getMetaData();
        }
    }
}
