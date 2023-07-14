package org.toolkit4j.libs.io.base;

import java.util.PriorityQueue;
import lombok.Builder;
import lombok.ToString;
import org.toolkit4j.libs.io.constant.FS;

@Builder
@ToString
public class IOManager {

	@Builder.Default
	private PriorityQueue<FS> fs = new PriorityQueue<>();

	private final IOConfig ioConfig;
}
