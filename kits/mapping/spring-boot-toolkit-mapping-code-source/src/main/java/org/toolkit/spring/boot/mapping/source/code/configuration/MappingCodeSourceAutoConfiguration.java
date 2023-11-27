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
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(MappingCodeSourceConfigurationProperties.class)
public class MappingCodeSourceAutoConfiguration {

	@Resource
	private ApplicationContext context;

	@Resource
	private MappingCodeSourceConfigurationProperties codeSourceConfigurationProperties;

	@PostConstruct
	public void init() {
		//        val pkg = getBasePackages().toArray(String[]::new);
		//        val classGraph = new ClassGraph().verbose().enableAllInfo().acceptPackages(pkg);
		//        try (val result = classGraph.scan(Runtime.getRuntime().availableProcessors())) {
		//            val infos = result.getClassesWithAnnotation(EnumMapping.class);
		//            infos.getEnums().forEach(System.err::println);
		//            infos.getStandardClasses().forEach(info -> {
		//                info.getFieldInfo().forEach(fieldInfo -> {
		//                    System.err.println(fieldInfo.getName());
		//                    System.err.println(fieldInfo.isStatic());
		//                });
		//            });
		//        }
	}

	@Bean
	public ClassGraph classGraph() {
		val pkg = getBasePackages().toArray(String[]::new);
		val classgraph = new ClassGraph().enableAllInfo().acceptClasses(pkg);
		if (codeSourceConfigurationProperties.getDebug()) {
			classgraph.verbose();
		}
		return classgraph;
	}

	private List<String> getBasePackages() {
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
