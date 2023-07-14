package org.toolkit4j.framework.spring.starter.io.configuration;

import com.google.common.jimfs.Jimfs;
import java.nio.file.FileSystem;
import lombok.Data;
import lombok.ToString;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.toolkit4j.libs.io.base.IOManager;

@ConfigurationProperties(prefix = "io.file.system", ignoreInvalidFields = true)
@Data
@ToString
public class FileSystemIOConfigurationProperties {

	private String basePath = System.getProperty("java.io.tmpdir");

	@Bean(name = "memoryFileSystem")
	@ConditionalOnMissingBean(FileSystem.class)
	public FileSystem fileSystem() {
		return Jimfs.newFileSystem();
	}

	@Bean
	public IOManager io() {
		return IOManager.builder().build();
	}
}
