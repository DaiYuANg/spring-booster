/* (C)2023*/
package org.spring.boost.web.core.mappings;

import java.lang.reflect.Method;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.web.annotation.Version;
import org.spring.boost.web.core.conditions.VersioningCondition;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

@Slf4j
public class VersionMappingHandler extends RequestMappingInfoHandlerMapping {
	@Override
	protected boolean isHandler(@NotNull Class<?> beanType) {
		val version = AnnotationUtils.findAnnotation(beanType, Version.class);
		return Objects.nonNull(version);
	}

	@Override
	protected RequestMappingInfo getMappingForMethod(@NotNull Method method, @NotNull Class<?> handlerType) {
		//        val version = AnnotationUtils.findAnnotation(method, Version.class);
		//        return createCondition(version);
		return null;
	}

	private RequestCondition<VersioningCondition> createCondition(Version version) {
		return version == null ? null : new VersioningCondition(version);
	}
}
