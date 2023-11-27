package org.toolkit.spring.boot.scanner.autoconfigure;

import io.github.classgraph.ClassGraph;
import jakarta.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.toolkit.spring.boot.scanner.lifecycle.Scanner;
import org.toolkit.spring.boot.utils.bean.BeanUtil;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(ScannerConfigurationProperties.class)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
public class ScannerAutoConfiguration {
	@Resource
	private ApplicationContext context;

	@Resource
	private ScannerConfigurationProperties scannerConfigurationProperties;

	@Bean
	public ClassGraph classGraph() {
		val pkg = getBasePackages().toArray(String[]::new);
		val classgraph = new ClassGraph().enableAllInfo().acceptClasses(pkg);
		if (scannerConfigurationProperties.getDebug()) {
			classgraph.enableRealtimeLogging();
		}
		return classgraph;
	}

	@Bean
	public Scanner scanner(ClassGraph classGraph, BeanUtil beanUtil) {
		return new Scanner(classGraph, beanUtil);
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
