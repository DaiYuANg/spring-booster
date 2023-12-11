package org.toolkit.spring.boot.vertx.wrapper;

import io.vertx.core.file.FileSystem;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FileSystemWrapper {

	@Resource
	private FileSystem fileSystem;

	@PostConstruct
	public void init() {}

	public void read() {}
}
