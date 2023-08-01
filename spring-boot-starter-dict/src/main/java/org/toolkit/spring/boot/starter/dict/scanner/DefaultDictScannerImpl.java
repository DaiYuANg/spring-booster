package org.toolkit.spring.boot.starter.dict.scanner;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.starter.dict.annotations.DictMetadata;
import org.toolkit.spring.boot.starter.dict.funcational.DictFunctional;

@Slf4j
@Component
public class DefaultDictScannerImpl implements DictScanner {

	@Resource
	private ApplicationContext context;

	@PostConstruct
	public void init() {
		val allDict = context.getBeansWithAnnotation(DictMetadata.class);
	}

	@Override
	public Stream<Class<?>> scanPackages() {
		return null;
	}

	@Override
	public Stream<DictFunctional> collectDict(@NotNull Stream<Class<?>> scanned) {
		return null;
	}

	@Override
	public DictFunctional parseDictAnnotation(@NotNull Class<?> c) {
		return null;
	}

	// public Stream<String> processClasspath() {
	// val apps =
	// Arrays.stream(context.getBeanNamesForAnnotation(SpringBootApplication.class)).toList();
	// return Stream.concat(mainApplicationDefaultPackage(apps),
	// mainApplicationBasePackages(apps))
	// .distinct();
	// }

	// private Stream<String> mainApplicationBasePackages(@NotNull List<String>
	// mainApplicationClass) {
	// return mainApplicationClass.stream().flatMap(a ->
	// Arrays.stream(context.getBean(a).getClass()
	// .getAnnotation(SpringBootApplication.class).scanBasePackages())
	// );
	// }
	//
	// private Stream<String> mainApplicationDefaultPackage(@NotNull List<String>
	// mainApplicationClass) {
	// return mainApplicationClass.stream().map(a ->
	// context.getBean(a).getClass().getPackageName());
	// }

	// public Stream<Class<?>> scanPackages(@NotNull String basePackage) {
	// if (scannedClasspath.containsKey(basePackage)) return
	// scannedClasspath.get(basePackage);
	// log.info("Dict default scanner scanning:{}", basePackage);
	// val classes = reflections
	// .getTypesAnnotatedWith(DictMetadata.class)
	// .stream().filter(Class::isEnum)
	// .distinct();
	// scannedClasspath.put(basePackage, classes);
	// return classes;
	// }
	//
	// @Override
	// public Stream<DictFunctional> collectDict(@NotNull Stream<Class<?>> scanned)
	// {
	// return scanned.distinct()
	// .filter(d -> {
	// val metadata = d.getAnnotation(DictMetadata.class);
	// return Objects.nonNull(metadata) && !metadata.code().isBlank();
	// })
	// .map(this::parseDictAnnotation)
	// .distinct();
	// }
	//
	// @Override
	// public DictFunctional parseDictAnnotation(@NotNull Class<?> c) {
	// val metadata = c.getAnnotation(DictMetadata.class);
	// val items = Arrays.stream(c.getFields())
	// .map(field -> field.getAnnotation(DictValue.class))
	// .filter(Objects::nonNull)
	// .filter(v -> StrUtil.isNotBlank(v.code()) || StrUtil.isNotBlank(v.text()))
	// .map(this::buildDictItem)
	// .collect(Collectors.toConcurrentMap(DictItem::code, dictItem -> dictItem));
	// return DictFunctional.builder()
	// .description(metadata.desc())
	// .items(items)
	// .code(metadata.code())
	// .build();
	// }
	//
	// private DictItem buildDictItem(@NotNull DictValue dictValue) {
	// return
	// DictItem.builder().text(dictValue.text()).code(dictValue.code()).build();
	// }
}
