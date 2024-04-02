/* (C)2023*/
package org.spring.boost.cli;

import lombok.extern.slf4j.Slf4j;
import org.fusesource.jansi.AnsiConsole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.CommandScan;

@Slf4j
@SpringBootApplication
@CommandScan
public class SpringBoostCLI {

    static {
        AnsiConsole.systemInstall();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBoostCLI.class, args);
    }
}
