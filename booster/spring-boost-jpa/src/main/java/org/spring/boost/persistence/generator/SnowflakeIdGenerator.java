package org.spring.boost.persistence.generator;

import com.github.philippheuer.snowflake4j.Snowflake;
import com.github.philippheuer.snowflake4j.SnowflakeGenerator;
import lombok.val;
import org.hibernate.boot.model.relational.SqlStringGenerationContext;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SnowflakeIdGenerator implements IdentifierGenerator {

  @Override
  public void initialize(SqlStringGenerationContext context) {
    SnowflakeGenerator.setInstance(SnowflakeGenerator.builder().epochOffset(1L).nodeId(1).build());
  }

  @Override
  public Object generate(SharedSessionContractImplementor session, Object object) {
    val snowflake = SnowflakeGenerator.getInstance().nextSnowflake();
    return snowflake.getId();
  }
}
