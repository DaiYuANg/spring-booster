package org.kop.libs.io.base;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class IO {
    private final IOConfig ioConfig;

    public IO(IOConfig ioConfig) {
        this.ioConfig = ioConfig;
    }
}
