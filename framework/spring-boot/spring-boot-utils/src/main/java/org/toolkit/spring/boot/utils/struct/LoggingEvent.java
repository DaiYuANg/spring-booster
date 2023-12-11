package org.toolkit.spring.boot.utils.struct;

import cn.hutool.core.date.DateUtil;
import java.io.Serial;
import java.time.Clock;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

@Slf4j
@ToString
public abstract class LoggingEvent extends ApplicationEvent {
	@Serial
	private static final long serialVersionUID = 1L;

	public LoggingEvent(Object source) {
		super(source);
		log.atDebug().log("event source:{} at:{}", super.getSource(), DateUtil.date(this.getTimestamp()));
	}

	public LoggingEvent(Object source, Clock clock) {
		super(source, clock);
		log.atDebug().log("event source:{} at:{}", super.getSource(), DateUtil.date(clock.millis()));
	}
}
