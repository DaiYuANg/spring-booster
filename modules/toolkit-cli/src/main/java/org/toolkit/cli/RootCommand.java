package org.toolkit.cli;

import lombok.SneakyThrows;
import picocli.CommandLine;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;

@CommandLine.Command(name = "Toolkit", version = "Groovy picocli v4.0 demo",
        mixinStandardHelpOptions = true, // add --help and --version options
        description = "@|bold Groovy|@ @|underline picocli|@ example")
public class RootCommand implements Runnable {

    @CommandLine.Parameters(index = "0", description = "The file whose checksum to calculate.")
    private File file;

    @CommandLine.Option(names = {"-a", "--algorithm"}, description = "MD5, SHA-1, SHA-256, ...")
    private String algorithm = "SHA-256";

    @SneakyThrows
    @Override
    public void run() { // your business logic goes here...
        byte[] fileContents = Files.readAllBytes(file.toPath());
        byte[] digest = MessageDigest.getInstance(algorithm).digest(fileContents);
        System.out.printf("%0" + (digest.length * 2) + "x%n", new BigInteger(1, digest));
    }
}
