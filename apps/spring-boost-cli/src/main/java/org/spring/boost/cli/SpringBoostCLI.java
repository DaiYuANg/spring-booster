/* (C)2023*/
package org.spring.boost.cli;

import lombok.extern.slf4j.Slf4j;
import org.fusesource.jansi.AnsiConsole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringBoostCLI {

    static {
        AnsiConsole.systemInstall();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBoostCLI.class, args);
    }
}
