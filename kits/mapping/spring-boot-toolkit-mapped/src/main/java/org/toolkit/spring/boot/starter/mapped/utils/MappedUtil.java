package org.toolkit.spring.boot.starter.mapped.utils;

import cn.hutool.core.collection.CollUtil;
import java.util.Arrays;
import lombok.experimental.UtilityClass;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.toolkit.spring.boot.starter.mapped.annotations.Mapped;
import org.toolkit.spring.boot.starter.mapped.annotations.Mapping;

@UtilityClass
public class MappedUtil {
	public boolean isMappedTarget(@NotNull Class<?> clazz) {
		val isPresentMapped = clazz.isAnnotationPresent(Mapped.class);
		val fields = Arrays.stream(clazz.getDeclaredFields())
				.peek(field -> field.setAccessible(true))
				.filter(field -> field.isAnnotationPresent(Mapping.class))
				.toList();
		return CollUtil.isNotEmpty(fields) && isPresentMapped;
	}
}
