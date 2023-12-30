/* (C)2023*/
package org.toolkit.spring.boot.minio.vo;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;

@Data
@ToString
@Accessors(chain = true)
@Builder
public class PreviewVo {

	private MediaType mediaType;

	private ByteArrayResource resource;
}
