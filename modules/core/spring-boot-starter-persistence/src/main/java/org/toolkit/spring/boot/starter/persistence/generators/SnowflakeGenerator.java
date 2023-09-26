package org.toolkit.spring.boot.starter.persistence.generators;

import cn.hutool.core.util.IdUtil;
import org.toolkit.spring.boot.starter.persistence.base.IGenerator;

public class SnowflakeGenerator implements IGenerator {
	@Override
	public String generate() {
		IdUtil.getSnowflake();
		return null;
	}
}
