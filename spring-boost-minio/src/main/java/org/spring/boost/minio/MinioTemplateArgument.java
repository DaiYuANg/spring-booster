/* (C)2024*/
package org.spring.boost.minio;

import com.google.common.collect.ImmutableSet;
import io.minio.MinioClient;
import io.minio.admin.MinioAdminClient;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import okhttp3.OkHttpClient;
import org.apache.tika.Tika;
import org.spring.boost.minio.hook.MinioHook;
import org.spring.boost.minio.properties.MinioClientConfig;

/**
 * Argument for template
 *
 * @author daiyuang
 * @since 2024.1.4
 */
@Builder
@Getter
public class MinioTemplateArgument {
    private final MinioClient client;

    private final MinioAdminClient adminClient;

    /**
     * The default bucket in template where no bucket argument method
     */
    private final String bucket;

    /**
     * If you do not hava a tika instance just create a not configured
     */
    @Builder.Default
    private final Tika tika = new Tika();

    /**
     * Minio hooks of method life cycle
     */
    @Singular
    private final ImmutableSet<MinioHook> hooks;

    /**
     * Is check duplicate flag
     */
    @Builder.Default
    private final boolean checkDuplicate = false;

    private final OkHttpClient okHttpClient;

    private final MinioClientConfig config;
}
