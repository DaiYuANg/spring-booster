package org.toolkit.spring.boot.mapping.core.utils;

import cn.hutool.core.collection.CollUtil;
import java.util.Arrays;
import lombok.experimental.UtilityClass;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.toolkit.spring.boot.mapping.base.annotation.Mapping;
import org.toolkit.spring.boot.mapping.base.annotation.MappingProperty;

@UtilityClass
public class MappedUtil {
	public boolean isMappedTarget(@NotNull Class<?> clazz) {
		val isPresentMapped = clazz.isAnnotationPresent(MappingProperty.class);
		val fields = Arrays.stream(clazz.getDeclaredFields())
				.peek(field -> field.setAccessible(true))
				.filter(field -> field.isAnnotationPresent(Mapping.class))
				.toList();
		return CollUtil.isNotEmpty(fields) && isPresentMapped;
	}
}
