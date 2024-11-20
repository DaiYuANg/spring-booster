/* (C)2023*/
package org.spring.boost.core.event;

import java.io.Serial;
import java.text.DateFormat;
import java.time.Clock;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

@Slf4j
@ToString
@SuppressWarnings({"this-escape", "unused"})
public abstract class LoggingEvent extends ApplicationEvent {
  @Serial
  private static final long serialVersionUID = 1L;

  public LoggingEvent(Object source) {
    super(source);
    logging();
  }

  public LoggingEvent(Object source, Clock clock) {
    super(source, clock);
    logging();
  }

  private void logging() {
    log.atTrace()
      .log(
        "event source:{} at:{}",
        super.getSource(),
        DateFormat.getDateTimeInstance().format(getTimestamp()));
  }
}
