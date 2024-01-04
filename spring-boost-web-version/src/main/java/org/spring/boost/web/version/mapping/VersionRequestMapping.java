/* (C)2023*/
package org.spring.boost.web.version.mapping;

import java.lang.reflect.Method;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Slf4j
public class VersionRequestMapping extends RequestMappingHandlerMapping {
	@Override
	protected RequestCondition<?> getCustomMethodCondition(@NonNull @NotNull Method method) {
		return super.getCustomMethodCondition(method);
	}

	@Override
	protected RequestCondition<?> getCustomTypeCondition(@NonNull @NotNull Class<?> handlerType) {
		return super.getCustomTypeCondition(handlerType);
	}
}
