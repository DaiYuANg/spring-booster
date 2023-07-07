package org.kop.framework.spring.starter.dev.admin.ui.ws;

import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@ServerEndpoint("/dev/admin/system/info")
@Component
@Slf4j
public class SystemInfoEndpoint {

}
