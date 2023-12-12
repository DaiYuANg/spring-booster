/* (C)2023*/
package org.toolkit.minio;

import io.minio.MinioAsyncClient;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.apache.tika.Tika;

@Data
@ToString
@Builder
public class MinioTemplateBuilder {

	@Builder.Default
	private String defaultContentType = "application/octet-stream";

	@Builder.Default
	private Tika tika = new Tika();

	@NonNull private String defaultBucket;

	private MinioAsyncClient minioAsyncClient;
}
