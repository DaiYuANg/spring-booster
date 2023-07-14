package org.toolkit4j.framework.spring.boot.starter.dict.services;

import java.util.Map;
import org.jetbrains.annotations.NotNull;

public interface IDictService {
	Map<String, Object> translate(@NotNull Object object);
}
