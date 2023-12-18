/* (C)2023*/
package org.toolkit.spring.boot.mapping.core.scan;

import io.github.classgraph.ClassInfo;
import io.github.classgraph.MethodInfo;
import io.github.classgraph.ScanResult;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.scanner.base.ScannerResultProcessor;

@Component
@Slf4j
public class ScanAdviceMethodMetaData implements ScannerResultProcessor {
	@Override
	public void process(@NotNull ScanResult result, ConfigurableApplicationContext context) {
		log.info("scan method");
		//		val methods = result.getClassesWithMethodAnnotation(MappingTarget.class).stream()
		//				.flatMap(this::getMappingObjectMethod)
		//				.toList();
		//		methods.forEach(method -> {
		//			log.info("method:{}", method.getTypeDescriptor().getResultType());
		//			System.err.println(method.getTypeDescriptor().getResultType());
		//		});
	}

	private Stream<? extends MethodInfo> getMappingObjectMethod(@NotNull ClassInfo advice) {
		//		return advice.getMethodInfo().stream().filter(methodInfo -> methodInfo.hasAnnotation(MappingTarget.class));
		return Stream.empty();
	}
}
