package org.toolkit.spring.boot.mapping.source.code.configuration;

import io.github.classgraph.*;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.toolkit.spring.boot.mapping.source.code.annotation.EnumMapping;

@AutoConfiguration
@Slf4j
public class MappingSourceEnumerationAutoConfiguration {

	@Resource
	private ApplicationContext context;

	@PostConstruct
	public void init() {
		val pkg = getBasepackages().toArray(String[]::new);
		val classGraph = new ClassGraph().verbose().enableAllInfo().acceptPackages(pkg);
		try (val result = classGraph.scan(Runtime.getRuntime().availableProcessors())) {
			val infos = result.getClassesWithAnnotation(EnumMapping.class);
			infos.getEnums().forEach(System.err::println);
			infos.getStandardClasses().forEach(info -> {
				info.getFieldInfo().forEach(fieldInfo -> {
					System.err.println(fieldInfo.getName());
					System.err.println(fieldInfo.isStatic());
				});
			});
		}
	}

	private List<String> getBasepackages() {
		return context.getBeansWithAnnotation(SpringBootApplication.class).values().stream()
				.flatMap(main -> {
					val ann = main.getClass().getAnnotation(SpringBootApplication.class);
					val packageName = main.getClass().getPackageName();
					val scan = Arrays.stream(ann.scanBasePackages()).toList();
					if (scan.isEmpty()) return Stream.of(packageName);
					return scan.stream();
				})
				.distinct()
				.toList();
	}
}
