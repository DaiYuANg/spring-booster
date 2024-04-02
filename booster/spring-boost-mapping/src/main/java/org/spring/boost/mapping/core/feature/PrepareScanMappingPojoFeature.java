package org.spring.boost.mapping.core.feature;

import com.google.auto.service.AutoService;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.FieldInfo;
import io.github.classgraph.ScanResult;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.dynamic.TypeResolutionStrategy;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.core.api.ClassPathScannerFeatureInstaller;
import org.spring.boost.mapping.core.annotation.*;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

@AutoService(ClassPathScannerFeatureInstaller.class)
@Slf4j
@SuppressWarnings("unused")
public class PrepareScanMappingPojoFeature implements ClassPathScannerFeatureInstaller {

  private final ByteBuddy byteBuddy = new ByteBuddy(ClassFileVersion.JAVA_V21);

  @SneakyThrows
  @Override
  public void install(@NotNull ConfigurableApplicationContext context, @NotNull ScanResult scanResult) {
    val factory = context.getBeanFactory();
    val allMappedPojo = scanResult.getClassesWithFieldAnnotation(Mapping.class);
    log.atTrace().log("Mapped pojo,{}", allMappedPojo);
    for (ClassInfo classInfo : allMappedPojo) {
      val builder = byteBuddy
        .subclass(classInfo.loadClass())
        .withToString()
        .withHashCodeEquals();
      val additionalFieldName = new ArrayList<String>();
      for (FieldInfo fieldInfo : classInfo.getFieldInfo()) {
        if (Boolean.FALSE.equals(fieldInfo.hasAnnotation(Mapping.class))) {
          continue;
        }
        val mappingAnnotation = fieldInfo.loadClassAndGetField().getAnnotation(Mapping.class);
        val kvMappingFieldNames = Arrays.stream(mappingAnnotation.kvMappings())
          .map(KeyValueMapping::config)
          .map(MappingConfig::fieldName)
          .toList();
        val tableFieldNames = Arrays.stream(mappingAnnotation.tableMappings()).map(TableMapping::config)
          .map(MappingConfig::fieldName).toList();
        val providerNames = Arrays.stream(mappingAnnotation.providers()).map(ProviderMapping::config).map(MappingConfig::fieldName).toList();
        additionalFieldName.addAll(kvMappingFieldNames);
        additionalFieldName.addAll(tableFieldNames);
        additionalFieldName.addAll(providerNames);
      }


      for (String o : additionalFieldName) {
        builder.defineField(o, String.class);
      }
      val name = classInfo.getName() + "MappingPojo";
      builder.name(name);
      val a = builder.make(TypeResolutionStrategy.Lazy.INSTANCE)
        .load(this.getClass().getClassLoader()).getLoaded()
        .getConstructor()
        .newInstance();

      factory.registerSingleton(name, a);
    }
  }
}
