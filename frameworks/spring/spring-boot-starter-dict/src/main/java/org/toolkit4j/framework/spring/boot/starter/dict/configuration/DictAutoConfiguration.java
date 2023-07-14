package org.toolkit4j.framework.spring.boot.starter.dict.configuration;

import com.google.gson.Gson;
import jakarta.annotation.Resource;
import java.util.Arrays;
import java.util.stream.Stream;
import lombok.val;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.toolkit4j.framework.spring.boot.starter.dict.scanner.DefaultDictScannerImpl;
import org.toolkit4j.framework.spring.boot.starter.dict.scanner.DictScanner;

@Configuration
@ComponentScan("org.toolkit4j.framework.spring.boot.starter.dict.**.*")
@EnableJpaRepositories("org.toolkit4j.framework.spring.boot.starter.dict.repos")
@EntityScan({"org.toolkit4j.framework.spring.boot.starter.dict"})
@EnableConfigurationProperties(DictConfigurationProperties.class)
public class DictAutoConfiguration {
	@Resource
	private DictConfigurationProperties dictConfigurationProperties;

	@Resource
	private ApplicationContext context;

	@Bean
	@ConditionalOnMissingBean(value = {Gson.class})
	public Gson gson() {
		return new Gson();
	}

	@Bean
	public DictScanner dictScanner() {
		return new DefaultDictScannerImpl();
	}

	@Bean
	public Reflections reflections() {
		val apps = Arrays.stream(context.getBeanNamesForAnnotation(SpringBootApplication.class))
				.toList();
		val defaultPackageName =
				apps.stream().map(a -> context.getBean(a).getClass().getPackageName());
		val scan = apps.stream()
				.flatMap(a -> Arrays.stream(context.getBean(a)
						.getClass()
						.getAnnotation(SpringBootApplication.class)
						.scanBasePackages()));
		val all = Stream.concat(defaultPackageName, scan).distinct().toArray(String[]::new);
		return new Reflections(new ConfigurationBuilder()
				.forPackages(all)
				.setParallel(true)
				.setScanners(Scanners.TypesAnnotated, Scanners.FieldsAnnotated, Scanners.SubTypes)
				.setExpandSuperTypes(true));
	}
}
