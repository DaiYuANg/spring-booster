package org.toolkit.spring.boot.mapping.indexer;

import com.google.auto.service.AutoService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;
import org.jetbrains.annotations.NotNull;
import org.mapstruct.MappingTarget;

@SupportedAnnotationTypes({"*"})
@SupportedSourceVersion(SourceVersion.RELEASE_21)
@AutoService(Processor.class)
public class MappingTargetIndexerProcessor extends AbstractProcessor {

	private Messager messager;
	private Elements elementUtils;

	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		messager = processingEnv.getMessager();
		elementUtils = processingEnv.getElementUtils();
	}

	@Override
	public boolean process(@NotNull Set<? extends TypeElement> annotations, @NotNull RoundEnvironment roundEnv) {
		log("mapping indexer1");
		// Check if the annotated element is a method
		// Get the return type of the method
		// Check if it's a declared type (e.g., a class or interface)
		roundEnv.getElementsAnnotatedWith(MappingTarget.class).stream()
				.filter(element -> element.getKind() == ElementKind.METHOD)
				.map(element -> (ExecutableElement) element)
				.forEach(methodElement -> {
					TypeMirror returnTypeMirror = methodElement.getReturnType();
					if (returnTypeMirror instanceof DeclaredType declaredType) {
						// Get the type parameters of the declared type
						List<? extends TypeMirror> typeArguments = declaredType.getTypeArguments();

						// Print information about the type arguments
						if (typeArguments.isEmpty()) {
							messager.printMessage(
									Diagnostic.Kind.NOTE,
									"Method " + methodElement.getSimpleName()
											+ " does not have generic type arguments.");
						} else {
							messager.printMessage(
									Diagnostic.Kind.NOTE,
									"Method " + methodElement.getSimpleName() + " has generic type arguments:");

							// Check if it's a declared type
							// Get the type element
							// Process fields of the type element
							typeArguments.forEach(typeArgument -> {
								messager.printMessage(Diagnostic.Kind.NOTE, "  - Type argument: " + typeArgument);
								if (!(typeArgument instanceof DeclaredType)) {
									return;
								}
								TypeElement typeElement = (TypeElement) ((DeclaredType) typeArgument).asElement();
								processFields(typeElement);
							});
						}
					}
				});
		return true;
	}

	protected void log(String msg) {
		processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, msg);
	}

	private void processFields(@NotNull TypeElement typeElement) {
		// Get fields of the type element
		List<? extends Element> enclosedElements = typeElement.getEnclosedElements();

		// Check if the enclosed element is a field
		// Get the annotations on the field
		// Process annotations on the field
		enclosedElements.stream()
				.filter(enclosedElement -> enclosedElement.getKind() == ElementKind.FIELD)
				.map(enclosedElement -> (VariableElement) enclosedElement)
				.forEach(fieldElement -> {
					List<? extends AnnotationMirror> annotationMirrors = fieldElement.getAnnotationMirrors();
					if (annotationMirrors.isEmpty()) {
						return;
					}
					messager.printMessage(
							Diagnostic.Kind.NOTE, "Field " + fieldElement.getSimpleName() + " has annotations:");
					for (AnnotationMirror annotationMirror : annotationMirrors) {
						messager.printMessage(
								Diagnostic.Kind.NOTE, "  - Annotation: " + annotationMirror.getAnnotationType());

						// Get annotation values
						Map<? extends ExecutableElement, ? extends AnnotationValue> elementValues =
								annotationMirror.getElementValues();
						for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry :
								elementValues.entrySet()) {
							messager.printMessage(
									Diagnostic.Kind.NOTE,
									"    - " + entry.getKey().getSimpleName() + ": " + entry.getValue());
						}
					}
				});
	}
}
