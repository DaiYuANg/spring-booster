package org.kop.framework.spring.boot.starter.groundwork.dict.services;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public interface IDictService {
    Map<String, Object> translate(@NotNull Object object);
}
