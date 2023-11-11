package org.toolkit.cli.terminal;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.jline.reader.LineReader;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
@Slf4j
public class KeyListener {

	@Resource
	@Lazy
	private LineReader lineReader;

	@EventListener(ApplicationStartedEvent.class)
	@Async
	public void init(ApplicationStartedEvent event) {
		lineReader.getBuffer().write("test");
		log.info("123:{}", lineReader.getKeyMap());
	}
}
