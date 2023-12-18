/* (C)2023*/
package org.toolkit.spring.boot.mapping.source.code.scanner;

import static java.util.function.Predicate.not;

import com.google.auto.service.AutoService;
import com.google.common.collect.ImmutableTable;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.FieldInfo;
import io.github.classgraph.ScanResult;
import java.util.Optional;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ConfigurableApplicationContext;
import org.toolkit.spring.boot.mapping.source.code.annotation.StaticField;
import org.toolkit.spring.boot.mapping.source.code.processor.DataBeanProcessor;
import org.toolkit.spring.boot.scanner.base.ScannerResultProcessor;

@Slf4j
@AutoService(ScannerResultProcessor.class)
public class StaticFieldScanner implements ScannerResultProcessor {

	private final ImmutableTable.Builder<String, String, Object> builder = ImmutableTable.builder();

	public void process(@NonNull @NotNull ScanResult result, @NonNull @NotNull ConfigurableApplicationContext context) {
		log.atInfo().log("static field processor");
		result.getAllClasses().forEach(this::processClasses);
		val dataTable = builder.build();
		val processor = new DataBeanProcessor(dataTable);
		context.addBeanFactoryPostProcessor(processor);
	}

	private void processClasses(@NotNull ClassInfo classInfo) {
		val fieldInfo = classInfo.getFieldInfo().stream()
				.filter(field -> field.isStatic() && field.hasAnnotation(StaticField.class) && field.isFinal());
		fieldInfo.forEach(this::processField);
	}

	@SneakyThrows
	private void processField(@NotNull FieldInfo field) {
		val jvmField = field.loadClassAndGetField();
		jvmField.setAccessible(true);
		val value = jvmField.get(null);
		log.atDebug().log("field:{}", field);
		log.atDebug().log("value:{}", value);
		val ann = jvmField.getAnnotation(StaticField.class);
		val label = Optional.ofNullable(ann.text()).filter(not(String::isBlank)).orElse(field.getName());
		val key = ann.key();
		builder.put(key, label, value);
	}
}
