package org.kop.framework.spring.starter.dev.admin.endpoint.services;

import lombok.SneakyThrows;

public interface IDevAdminService {
    @SneakyThrows
    String currentSystem();
}
