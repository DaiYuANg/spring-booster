/* (C)2023*/
package org.nectar.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringBoostCLI {

//	static {
//		AnsiConsole.systemInstall();
//	}
//
//	@SneakyThrows
//	public static void main(String[] args) {
//		val command = new CommandLine(new RootCommand(), new GuiceFactory());
//		val exec = command.execute(args);
//		System.exit(exec);
//	}

    public static void main(String[] args) {
        SpringApplication.run(SpringBoostCLI.class, args);
    }
}
