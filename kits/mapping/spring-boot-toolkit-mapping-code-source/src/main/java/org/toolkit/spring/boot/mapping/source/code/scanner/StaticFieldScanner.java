package org.toolkit.spring.boot.mapping.source.code.scanner;

import io.github.classgraph.ClassInfo;
import io.github.classgraph.FieldInfo;
import io.github.classgraph.ScanResult;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import org.toolkit.spring.boot.mapping.source.code.annotation.StaticField;
import org.toolkit.spring.boot.scanner.base.ScannerResultProcessor;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class StaticFieldScanner implements ScannerResultProcessor {

	public void process(@NotNull ScanResult result) {
		log.atInfo().log("static field processor");
		val r = result.getAllClasses().stream()
				.flatMap(this::processClasses)
				.collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
		System.err.println(r);
	}

	@NotNull private Stream<Map.Entry<String, Object>> processClasses(@NotNull ClassInfo classInfo) {
		val fieldInfo = classInfo.getFieldInfo().stream()
				.filter(field -> field.isStatic() && field.hasAnnotation(StaticField.class) && field.isFinal());
		return fieldInfo.map(this::processField);
	}

	@SneakyThrows
	private Map.@NotNull @Unmodifiable Entry<String, Object> processField(@NotNull FieldInfo field) {
		val jvmField = field.loadClassAndGetField();
		jvmField.setAccessible(true);
		var value = jvmField.get(null);
		log.info("field:{}", field);
		log.info("value:{}", value);
		val ann = jvmField.getAnnotation(StaticField.class);
		val key = ann.value();
		return Map.entry(key, value);
	}
}
