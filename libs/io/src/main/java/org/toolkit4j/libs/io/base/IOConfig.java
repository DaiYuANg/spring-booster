package org.toolkit4j.libs.io.base;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.toolkit4j.libs.io.constant.FileSystemType;

@Data
@ToString
@Builder
public class IOConfig {
    private FileSystemType type;

    private String baseURL;
}
