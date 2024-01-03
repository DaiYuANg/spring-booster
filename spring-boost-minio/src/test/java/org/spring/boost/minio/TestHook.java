/* (C)2024*/
package org.spring.boost.minio;

import jakarta.annotation.PostConstruct;

public class TestHook {

	@PostConstruct
	public void init() {
		System.err.println(123);
	}
}
