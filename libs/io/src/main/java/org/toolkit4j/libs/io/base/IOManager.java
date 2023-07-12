package org.toolkit4j.libs.io.base;

import lombok.Builder;
import lombok.ToString;
import org.toolkit4j.libs.io.constant.FS;

import java.util.PriorityQueue;

@Builder
@ToString
public class IOManager {

    @Builder.Default
    private PriorityQueue<FS> fs = new PriorityQueue<>();

    private final IOConfig ioConfig;
}
