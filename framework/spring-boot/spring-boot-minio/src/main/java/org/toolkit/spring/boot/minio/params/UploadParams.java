package org.toolkit.spring.boot.minio.params;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

@Builder
@ToString
@Getter
@Setter
@Accessors(chain = true)
public class UploadParams extends CommonUploadParams {
	private MultipartFile file;
}
