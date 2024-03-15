/* (C)2023*/
package org.spring.boost.persistence.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "persistence")
@Setter
@Getter
@ToString
public class PersistenceConfigurationProperties {}
