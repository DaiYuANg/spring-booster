package org.spring.boost.persistence.generator;

import cn.hutool.extra.spring.SpringUtil;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.agrona.concurrent.SnowflakeIdGenerator;
import org.hibernate.boot.model.relational.SqlStringGenerationContext;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.spring.boost.persistence.autoconfigure.GeneratorConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextException;


@Slf4j
public class HibernateSnowflakeIdGenerator implements IdentifierGenerator {

  private final SnowflakeIdGenerator generator;

  public HibernateSnowflakeIdGenerator() {
    val properties = Try.of(SpringUtil::getApplicationContext)
      .mapTry(ApplicationContext::getEnvironment)
      .mapTry(Binder::get)
      .map(GeneratorConfigurationProperties::get)
      .getOrElseThrow(() -> new ApplicationContextException("No Context Founded"));
    log.atTrace().log("Generator Config:{}", properties);
    this.generator = new SnowflakeIdGenerator(1);
  }

  @Override
  public void initialize(SqlStringGenerationContext context) {
//    setInstance(generator);
  }

  @Override
  public Object generate(SharedSessionContractImplementor session, Object object) {
    return generator.nextId();
  }
}
