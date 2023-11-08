package org.toolkit.cli.command;

// import io.smallrye.config.SmallRyeConfig;

import static org.fusesource.jansi.Ansi.Color.GREEN;
import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.ansi;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.fusesource.jansi.AnsiConsole;
import picocli.CommandLine;

import javax.lang.model.element.Modifier;

@CommandLine.Command(name = "generate", aliases = "g")
@Slf4j
public class GenerateCommand implements Runnable {

    @CommandLine.Option(
            names = {"-c", "--copy-contract"},
            description = "Do you want to copy the contract in to the project?",
            interactive = true,
            arity = "0")
    String configFile;

    @CommandLine.Parameters()
    String packageName;

    @SneakyThrows
    @Override
    public void run() {
        MethodSpec main = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.ABSTRACT)
                .addMethod(main)
                .build();

        JavaFile javaFile = JavaFile.builder(packageName, helloWorld)
                .build();

        javaFile.writeTo(System.out);
        System.out.println(
                ansi().eraseScreen().fg(RED).a("Hello").fg(GREEN).a(" World").reset());
    }
}
