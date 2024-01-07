/* (C)2023*/
package org.spring.boost.mapping.database.source.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "toolkit.mapping.source.database")
@Getter
@Setter
@ToString
public class MappingDatabaseSourceProperties {

    private String threadPoolPrefix = "MappingDatabaseSource";
}
