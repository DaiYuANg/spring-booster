package org.toolkit.cli.command;

import com.google.inject.Guice;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.toolkit.cli.module.RootModule;
import picocli.CommandLine;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;

@CommandLine.Command(name = "Toolkit", version = "Groovy picocli v4.0 demo",
        mixinStandardHelpOptions = true, // add --help and --version options
        description = "@|bold Groovy|@ @|underline picocli|@ example")
@Slf4j
public class RootCommand implements Runnable {

    @SneakyThrows
    @Override
    public void run() { // your business logic goes here...
        Guice.createInjector(new RootModule());
        log.info("run");
//        byte[] fileContents = Files.readAllBytes(file.toPath());
//        byte[] digest = MessageDigest.getInstance(algorithm).digest(fileContents);
//        System.out.printf("%0" + (digest.length * 2) + "x%n", new BigInteger(1, digest));
    }
}
