package org.toolkit.spring.boot.utils.struct;

import cn.hutool.core.date.DateUtil;
import java.time.Clock;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

@Slf4j
@ToString
public abstract class LoggingEvent extends ApplicationEvent {
	public LoggingEvent(Object source) {
		super(source);
		log.atDebug().log("event source:{} at:{}", this.getSource(), DateUtil.date(this.getTimestamp()));
	}

	public LoggingEvent(Object source, Clock clock) {
		super(source, clock);
		log.atDebug().log("event source:{} at:{}", this.getSource(), DateUtil.date(clock.millis()));
	}
}
