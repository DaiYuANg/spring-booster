package org.kop.framework.spring.starter.dev.admin.endpoint.services.impl;

import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.kop.framework.spring.starter.dev.admin.configurations.endpoint.ServerBasicInfo;
import org.kop.framework.spring.starter.dev.admin.constants.Base;
import org.kop.framework.spring.starter.dev.admin.endpoint.services.IDevAdminService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
    public String currentSystem() {
        try (val r = okHttpClient.newCall(new Request.Builder()
                .url(serverBasicInfo.fullAccessPath() +
                        env.getProperty("management.endpoints.web.base-path", Base.DEFAULT_ACTUATOR_PATH))
                .build()).execute()) {
            return Objects.requireNonNull(r.body()).string();
        }
    }
}
