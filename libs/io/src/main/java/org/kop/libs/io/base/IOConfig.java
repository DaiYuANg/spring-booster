package org.kop.libs.io.base;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class IOConfig {
    private FileSystemType type;

    private String baseURL;
}
