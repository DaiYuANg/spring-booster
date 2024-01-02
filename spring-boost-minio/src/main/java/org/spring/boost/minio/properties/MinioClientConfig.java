/* (C)2024*/
package org.spring.boost.minio.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MinioClientConfig {
	private String endpoint;

	private String accessKey;

	private String secretKey;

	private String bucket;

	private String region;

	private boolean enableAdmin = true;

	private boolean enableTemplate = true;

	//	private ImmutableSet<MinioHook> hooks;
}
