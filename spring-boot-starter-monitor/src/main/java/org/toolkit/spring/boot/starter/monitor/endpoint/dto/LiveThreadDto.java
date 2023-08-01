package org.toolkit.spring.boot.starter.monitor.endpoint.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class LiveThreadDto {
	private long threadId;
	private String threadName;
	private String threadState;
	private String lockName;
	private boolean daemon;
	private boolean inNative;
	private boolean suspended;
	private long lockOwnerId;
	private long blockedTime;
	private long blockedCount;
	private long waitedTime;
	private long waitedCount;
	private String lockerClassName;
}
