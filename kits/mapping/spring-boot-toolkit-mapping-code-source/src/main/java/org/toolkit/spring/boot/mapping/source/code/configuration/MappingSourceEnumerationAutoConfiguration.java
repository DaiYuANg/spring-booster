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
		;
		// Scan com.xyz and subpackages (omit to scan all packages);
		//        context.getBeansWithAnnotation(ComponentScan.class).forEach((name, instance) -> {
		//            Set<ComponentScan> scans =
		// AnnotatedElementUtils.getMergedRepeatableAnnotations(instance.getClass(), ComponentScan.class);
		//            for (ComponentScan scan : scans) {
		//                System.out.println(Arrays.toString(scan.basePackageClasses()));
		//                System.out.println(Arrays.toString(scan.basePackages()));
		//            }
		//        });
		//        System.err.println(context.getClass().getName());
		//        context.getBeansWithAnnotation(SpringBootApplication.class).values();
		//        String pkg = "com.xyz";
		//        try (ScanResult scanResult =
		//                     new ClassGraph()
		//                             .verbose()               // Log to stderr
		//                             .enableAllInfo()         // Scan classes, methods, fields, annotations
		//                             .acceptPackages(pkg)     // Scan com.xyz and subpackages (omit to scan all
		// packages)
		//                             .scan(Runtime.getRuntime().availableProcessors())) {               // Start the
		// scan
		//            // @com.xyz.Route has one required parameter
		//            scanResult.getClassesWithAnnotation(EnumMapping.class).forEach(routeClassInfo -> {
		//                AnnotationInfo routeAnnotationInfo = routeClassInfo.getAnnotationInfo(EnumMapping.class);
		//                List<AnnotationParameterValue> routeParamVals = routeAnnotationInfo.getParameterValues();
		//                String route = (String) routeParamVals.get(0).getValue();
		//                System.out.println(routeClassInfo.getName() + " is annotated with route " + route);
		//            });
		//        }
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
