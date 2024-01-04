/* (C)2024*/
package org.spring.boost.minio.factory;

import io.minio.MinioClient;
import io.minio.admin.MinioAdminClient;
import java.util.Set;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import okhttp3.OkHttpClient;
import org.apache.tika.Tika;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.minio.*;
import org.spring.boost.minio.hook.MinioHook;
import org.spring.boost.minio.properties.MinioClientConfig;
import org.spring.boost.minio.properties.MinioConfigurationProperties;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Common {@link MinioTemplate} factory TODO MinioTemplateArgument and MinioTemplate Builder pattern
 * maybe is bad design??
 *
 * @author daiyuang
 */
@Slf4j
@SuperBuilder
public abstract class TemplateFactory {
    protected final MinioConfigurationProperties properties;

    protected final Tika tika;

    protected final Set<MinioHook> hooks;

    protected final OkHttpClient httpClient;

    protected void registerTemplates(
            @NotNull String prefixKey, @NotNull ConfigurableListableBeanFactory beanFactory, MinioClientConfig config) {
        val client = beanFactory.getBean(BeanNaming.buildAdminName(BeanNaming.CLIENT), MinioClient.class);
        val adminClient = beanFactory.getBean(BeanNaming.buildAdminName(BeanNaming.ADMIN), MinioAdminClient.class);
        val arg = MinioTemplateArgument.builder()
                .client(client)
                .adminClient(adminClient)
                .tika(tika)
                .hooks(hooks)
                .okHttpClient(httpClient)
                .config(config)
                .checkDuplicate(properties.isCheckDuplicate())
                .build();
        val createTemplate = new MinioCreateTemplate(arg);
        val deleteTemplate = new MinioDeleteTemplate(arg);
        val getTemplate = new MinioGetTemplate(arg);
        val adminTemplate = new MinioAdminTemplate(arg);
        val aioTemplate = MinioTemplate.builder()
                .createTemplate(createTemplate)
                .deleteTemplate(deleteTemplate)
                .getTemplate(getTemplate)
                .adminTemplate(adminTemplate)
                .templateArg(arg)
                .build();
        val naming = prefixKey.isBlank()
                ? BeanNaming.buildAdminName(BeanNaming.TEMPLATE)
                : BeanNaming.buildAdminName(prefixKey, BeanNaming.TEMPLATE);
        beanFactory.registerSingleton(naming, aioTemplate);
    }
}
