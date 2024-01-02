/* (C)2024*/
package org.spring.boost.minio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestHookConfiguration {
	@Bean(name = "hook1")
	public TestHook testHook1() {
		return new TestHook();
	}

	@Bean(name = "hook2")
	public TestHook testHook2() {
		return new TestHook();
	}
}
