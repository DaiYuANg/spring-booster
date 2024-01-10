/* (C)2023*/
package org.spring.boost.dev.service.config;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DevServiceCommonConfigurationProperties {
    private String command;

    private List<Map<String, String>> environment;
}