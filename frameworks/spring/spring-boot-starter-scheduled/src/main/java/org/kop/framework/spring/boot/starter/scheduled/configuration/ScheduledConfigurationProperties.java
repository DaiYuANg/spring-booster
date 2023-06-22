package org.kop.framework.spring.boot.starter.scheduled.configuration;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("scheduled")
@Data
@ToString
public class ScheduledConfigurationProperties {
    private String defaultScheduledNamePrefix = "scheduled%d";

    private int coreSize = Runtime.getRuntime().availableProcessors();

    private boolean preheat = false;
}
