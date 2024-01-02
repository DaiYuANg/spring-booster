/* (C)2024*/
package org.spring.boost.minio;

import jakarta.annotation.PostConstruct;
import org.spring.boost.minio.hook.MinioHook;

public class TestHook implements MinioHook {

	@PostConstruct
	public void init() {
		System.err.println(123);
	}
}
