package org.toolkit.spring.boot.starter.minio.vo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class UploadResultVo {

    private String id;
}
