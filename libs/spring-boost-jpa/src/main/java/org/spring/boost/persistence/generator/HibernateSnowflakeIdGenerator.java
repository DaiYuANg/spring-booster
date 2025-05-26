package org.spring.boost.persistence.generator;

import cn.hutool.extra.spring.SpringUtil;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.agrona.concurrent.SnowflakeIdGenerator;
import org.agrona.concurrent.SystemEpochClock;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.persistence.autoconfigure.GeneratorConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextException;

import java.util.Optional;
import java.util.Properties;

import static java.util.Optional.ofNullable;
import static org.spring.boost.persistence.constant.Key.SNOW_FLAKE_HIBERNATE_PROPERTIES_KEY;

@Slf4j
public class HibernateSnowflakeIdGenerator implements IdentifierGenerator {

  private SnowflakeIdGenerator generator;

  private static final long DEFAULT_NODE_ID = 1L;

  @Override
  public void configure(Type type, @NotNull Properties params, ServiceRegistry serviceRegistry) {
    long nodeId = ofNullable(params.getProperty(SNOW_FLAKE_HIBERNATE_PROPERTIES_KEY))
      .map(this::parseNodeId)
      .orElse(DEFAULT_NODE_ID);

    // 初始化 Snowflake ID 生成器
    this.generator = new SnowflakeIdGenerator(nodeId);

    log.atInfo().log("Snowflake ID Generator initialized with node ID: {}", nodeId);
  }

  private long parseNodeId(String nodeIdString) {
    return Try.of(() -> Long.parseLong(nodeIdString)).getOrElseThrow((e) -> {
      throw new IllegalArgumentException("Invalid node ID for SnowflakeIdGenerator: " + nodeIdString, e);
    });
  }

  @Override
  public Object generate(SharedSessionContractImplementor session, Object object) {
    return ofNullable(generator).map(SnowflakeIdGenerator::nextId)
      .orElseThrow(() -> new IllegalStateException("HibernateSnowflakeIdGenerator is not properly configured"));
  }
}