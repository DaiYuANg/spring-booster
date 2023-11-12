package org.toolkit.spring.boot.minio.params;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public class Base64UploadParam extends CommonUploadParams {

	private String base64;
}
