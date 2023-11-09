package org.toolkit.spring.boot.persistence.generators;

import cn.hutool.core.util.IdUtil;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

public class SnowflakeGenerator extends SequenceStyleGenerator {
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return IdUtil.getSnowflake().nextId();
	}
}
