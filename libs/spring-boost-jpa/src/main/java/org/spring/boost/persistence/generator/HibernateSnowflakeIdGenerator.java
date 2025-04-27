package org.spring.boost.persistence.generator;

import cn.hutool.extra.spring.SpringUtil;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.agrona.concurrent.SnowflakeIdGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.spring.boost.persistence.autoconfigure.GeneratorConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextException;

import java.util.Optional;

import static java.util.Optional.ofNullable;


@Slf4j
public class HibernateSnowflakeIdGenerator implements IdentifierGenerator {

  private SnowflakeIdGenerator generator;

  @Override
  public Object generate(SharedSessionContractImplementor session, Object object) {
    ofNullable(generator)
      .ifPresentOrElse(g ->
          log.atDebug().log("Generate has been instantiated"),
        () -> {
          val properties = Try.of(SpringUtil::getApplicationContext)
            .mapTry(ApplicationContext::getEnvironment)
            .mapTry(Binder::get)
            .map(GeneratorConfigurationProperties::get)
            .getOrElseThrow((t) -> {
              log.atError().log(t.getMessage());
              return new ApplicationContextException("No Context Founded");
            });
          log.atTrace().log("Generator Config:{}", properties);
          this.generator = new SnowflakeIdGenerator(1);
        }
      );
    return generator.nextId();
  }
}