package org.spring.boost.admin.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.ext.web.client.WebClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.admin.model.ActuatorBeansResponse;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BeanService {
  private final WebClient webClient;

  public Uni<ActuatorBeansResponse> listBeans(){
    return webClient.get("/actuator/beans").send().map(resp-> resp.bodyAsJson(ActuatorBeansResponse.class));
  }
}
