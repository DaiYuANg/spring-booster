package org.spring.boost.cli.service.impl;

import com.palantir.javapoet.*;
import lombok.val;
import org.spring.boost.cli.service.GenerateService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.element.Modifier;

@Service
public class GenerateControllerService implements GenerateService {

  public void generate(){
    ClassName requestMapping = ClassName.get("org.springframework.web.bind.annotation", "RequestMapping");
    ClassName getMapping = ClassName.get("org.springframework.web.bind.annotation", "GetMapping");
    ClassName postMapping = ClassName.get("org.springframework.web.bind.annotation", "PostMapping");
    ClassName putMapping = ClassName.get("org.springframework.web.bind.annotation", "PutMapping");
    ClassName deleteMapping = ClassName.get("org.springframework.web.bind.annotation", "DeleteMapping");
    ClassName pathVariable = ClassName.get("org.springframework.web.bind.annotation", "PathVariable");
    ClassName requestBody = ClassName.get("org.springframework.web.bind.annotation", "RequestBody");

    ClassName userClass = ClassName.get("com.example.demo.model", "User");
    TypeName listOfUser = ParameterizedTypeName.get(ClassName.get("java.util", "List"), userClass);

    // GET /users
    MethodSpec getAll = MethodSpec.methodBuilder("getAllUsers")
      .addAnnotation(AnnotationSpec.builder(getMapping).build())
      .addModifiers(Modifier.PUBLIC)
      .returns(listOfUser)
      .addCode("// TODO: implement\nreturn null;\n")
      .build();

    // GET /users/{id}
    MethodSpec getById = MethodSpec.methodBuilder("getUserById")
      .addAnnotation(AnnotationSpec.builder(getMapping)
        .addMember("value", "$S", "/{id}")
        .build())
      .addModifiers(Modifier.PUBLIC)
      .returns(userClass)
      .addParameter(ParameterSpec.builder(Long.class, "id")
        .addAnnotation(AnnotationSpec.builder(pathVariable).build())
        .build())
      .addCode("// TODO: implement\nreturn null;\n")
      .build();

    // POST /users
    MethodSpec create = MethodSpec.methodBuilder("createUser")
      .addAnnotation(AnnotationSpec.builder(postMapping).build())
      .addModifiers(Modifier.PUBLIC)
      .returns(userClass)
      .addParameter(ParameterSpec.builder(userClass, "user")
        .addAnnotation(AnnotationSpec.builder(requestBody).build())
        .build())
      .addCode("// TODO: implement\nreturn null;\n")
      .build();

    // PUT /users/{id}
    MethodSpec update = MethodSpec.methodBuilder("updateUser")
      .addAnnotation(AnnotationSpec.builder(putMapping)
        .addMember("value", "$S", "/{id}")
        .build())
      .addModifiers(Modifier.PUBLIC)
      .returns(userClass)
      .addParameter(ParameterSpec.builder(Long.class, "id")
        .addAnnotation(AnnotationSpec.builder(pathVariable).build())
        .build())
      .addParameter(ParameterSpec.builder(userClass, "user")
        .addAnnotation(AnnotationSpec.builder(requestBody).build())
        .build())
      .addCode("// TODO: implement\nreturn null;\n")
      .build();

    // DELETE /users/{id}
    MethodSpec delete = MethodSpec.methodBuilder("deleteUser")
      .addAnnotation(AnnotationSpec.builder(deleteMapping)
        .addMember("value", "$S", "/{id}")
        .build())
      .addModifiers(Modifier.PUBLIC)
      .returns(TypeName.VOID)
      .addParameter(ParameterSpec.builder(Long.class, "id")
        .addAnnotation(AnnotationSpec.builder(pathVariable).build())
        .build())
      .addCode("// TODO: implement\n")
      .build();

    // Build the class
    TypeSpec userController = TypeSpec.classBuilder("UserController")
      .addModifiers(Modifier.PUBLIC)
      .addAnnotation(RestController.class)
      .addAnnotation(AnnotationSpec.builder(requestMapping)
        .addMember("value", "$S", "/users")
        .build())
      .addMethod(getAll)
      .addMethod(getById)
      .addMethod(create)
      .addMethod(update)
      .addMethod(delete)
      .build();
    String basePackage = "com.example.demo.controller";
    JavaFile javaFile = JavaFile.builder(basePackage, userController)
      .build();
  }
}
