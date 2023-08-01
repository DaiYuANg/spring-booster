package org.toolkit.spring.boot.starter.monitor.endpoint.services.impl;

import jakarta.annotation.Resource;
import java.util.Objects;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.starter.monitor.configurations.endpoint.ServerBasicInfo;
import org.toolkit.spring.boot.starter.monitor.constants.Base;
import org.toolkit.spring.boot.starter.monitor.endpoint.services.IDevAdminService;

@Service
@Slf4j
public class DevAdminServiceImpl implements IDevAdminService {
	@Resource
	private Environment env;

	@Resource
	private ServerBasicInfo serverBasicInfo;

	@Resource
	private OkHttpClient okHttpClient;

	@SneakyThrows
	@Override
	public String actuatorExport() {
		try (val r = okHttpClient
				.newCall(new Request.Builder()
						.url(serverBasicInfo.fullAccessPath()
								+ env.getProperty("management.endpoints.web.base-path", Base.DEFAULT_ACTUATOR_PATH))
						.build())
				.execute()) {
			return Objects.requireNonNull(r.body()).string();
		}
	}
}
