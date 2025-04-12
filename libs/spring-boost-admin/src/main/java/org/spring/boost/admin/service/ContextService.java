package org.spring.boost.admin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.core.api.BeanRegistry;
import org.spring.boost.core.api.FeatureInstaller;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContextService {

  private final BeanRegistry beanRegistry;

  private final Environment environment;

  public Set<FeatureInstaller> test(){
    return beanRegistry.getBeanDistinct(FeatureInstaller.class);
  }
}
