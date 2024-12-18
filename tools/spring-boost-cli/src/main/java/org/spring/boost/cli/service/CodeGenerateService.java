/* (C)2023*/
package org.spring.boost.cli.service;

import com.squareup.javapoet.*;
import freemarker.template.Configuration;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import javax.lang.model.element.Modifier;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class CodeGenerateService {

  private final Configuration configuration;

  public void entityGenerate() {
    val anno = AnnotationSpec.builder(Table.class)
      .addMember("name", "$S", "application/json; charset=utf-8")
      .addMember("userAgent", "$S", "Square Cash")
      .build();

    val helloWorld = TypeSpec.classBuilder("HelloWorld")
      .addAnnotation(Entity.class)
      .addAnnotation(anno)
      .addModifiers(Modifier.PUBLIC)
      .addField(FieldSpec.builder(String.class, "ONLY_THING_THAT_IS_CONSTANT")
        .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
        .initializer("$S", "change")
        .build())
      .addMethod(MethodSpec.methodBuilder("beep")
        .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
        .build())
      .build();

    JavaFile.builder("org.toolkit", helloWorld).build();
  }
}
