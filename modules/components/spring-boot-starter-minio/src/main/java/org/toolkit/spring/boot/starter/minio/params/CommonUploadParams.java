package org.toolkit.spring.boot.starter.minio.params;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommonUploadParams {
    private boolean anonymous;

    private String clientInstance;
}
