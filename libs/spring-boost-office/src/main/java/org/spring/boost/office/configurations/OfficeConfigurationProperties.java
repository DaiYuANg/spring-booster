/* (C)2023*/
package org.spring.boost.office.configurations;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "spring.boost.office")
@Setter
@Getter
@ToString
public class OfficeConfigurationProperties {

    @NestedConfigurationProperty
    private ObjectPoolConfig objectPool;

    @NestedConfigurationProperty
    private ExcelConfig excel;
}
