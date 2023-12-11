package org.toolkit.spring.boot.persistence.generators;

import cn.hutool.core.util.IdUtil;
import java.io.Serial;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

public class SnowflakeGenerator extends SequenceStyleGenerator {
	@Serial
	private static final long serialVersionUID = 1L;

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return String.valueOf(IdUtil.getSnowflake().nextId());
	}
}
