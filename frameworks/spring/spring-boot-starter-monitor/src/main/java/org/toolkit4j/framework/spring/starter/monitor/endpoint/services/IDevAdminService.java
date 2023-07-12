package org.toolkit4j.framework.spring.starter.monitor.endpoint.services;

import lombok.SneakyThrows;

public interface IDevAdminService {
    @SneakyThrows
    String actuatorExport();
}
