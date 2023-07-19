package org.toolkit4j.framework.spring.starter.io.minio;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
public class MinioInstance {
    private String endpoint;

    private String accessKey;

    private String secretKey;

    private boolean async;
}
