package org.spring.boost.codegen;

import io.avaje.prism.GenerateAPContext;
import io.avaje.prism.GenerateModuleInfoReader;
import io.avaje.prism.GeneratePrism;
import org.spring.boost.annotation.GenerateController;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes("org.spring.boost.annotation.GenerateController")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
@GeneratePrism(GenerateController.class)
@GenerateAPContext
@GenerateModuleInfoReader
@SuppressWarnings("unused")
public class CodegenProcessor extends AbstractProcessor {
  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    return false;
  }
}
