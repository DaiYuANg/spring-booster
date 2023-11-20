package org.toolkit.spring.boot.codegen;

import com.google.auto.service.AutoService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes({"*"})
@SupportedSourceVersion(SourceVersion.RELEASE_17)
@AutoService(Processor.class)
public class ControllerProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        log("code gen processor test");
//        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Hello\r\n");
        return true;
    }

    protected void log(String msg) {
//        if (processingEnv.getOptions().containsKey("debug")) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, msg);
//        }
    }
}
