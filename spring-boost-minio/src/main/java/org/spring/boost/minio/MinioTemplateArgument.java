package org.spring.boost.minio;

import com.google.common.collect.ImmutableSet;
import io.minio.MinioClient;
import io.minio.admin.MinioAdminClient;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import org.apache.tika.Tika;
import org.spring.boost.minio.hook.MinioHook;

@Builder
@Getter
public class MinioTemplateArgument {
    private final MinioClient client;

    private final MinioAdminClient adminClient;

    private final String bucket;

    @Builder.Default
    private final Tika tika = new Tika();

    @Singular
    private final ImmutableSet<MinioHook> hooks;

    @Builder.Default
    private final boolean checkDuplicate = false;
}
