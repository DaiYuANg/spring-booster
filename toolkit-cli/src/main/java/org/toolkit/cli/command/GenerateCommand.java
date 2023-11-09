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
import lombok.val;
import org.fusesource.jansi.AnsiConsole;
import org.toolkit.cli.service.ConfigService;
import picocli.CommandLine;

import javax.lang.model.element.Modifier;
import java.util.Optional;

@CommandLine.Command(name = "generate", aliases = "g")
@Slf4j
public class GenerateCommand implements Runnable {

    @CommandLine.Option(
            names = {"-c", "--generate-config"},
            description = "Set other toolkit cli config")
    Optional<String> configFile;

    @SneakyThrows
    @Override
    public void run() {
        log.info("start generate");
        val cf = configFile
                .map(ConfigService::new)
                .orElseGet(ConfigService::new);

//        MethodSpec main = MethodSpec.methodBuilder("main")
//                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
//                .returns(void.class)
//                .addParameter(String[].class, "args")
//                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
//                .build();
//
//        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
//                .addModifiers(Modifier.ABSTRACT)
//                .addMethod(main)
//                .build();
//
//        JavaFile javaFile = JavaFile.builder(packageName, helloWorld)
//                .build();
//
//        javaFile.writeTo(System.out);
//        System.out.println(
//                ansi().eraseScreen().fg(RED).a("Hello").fg(GREEN).a(" World").reset());
    }
}
