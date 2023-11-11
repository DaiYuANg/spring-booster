package org.toolkit.cli.resolver;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.shell.command.CommandHandlingResult;
import org.springframework.shell.command.annotation.ExceptionResolver;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
@Slf4j
public class GloballyExceptionResolver {
	@ExceptionResolver({RuntimeException.class})
	CommandHandlingResult errorHandler(@NotNull Exception e) {
		log.error(e.getMessage());
		return CommandHandlingResult.of("Hi, handled exception\n", 42);
	}
}
