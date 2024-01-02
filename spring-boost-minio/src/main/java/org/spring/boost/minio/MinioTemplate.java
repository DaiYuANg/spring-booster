/* (C)2024*/
package org.spring.boost.minio;

import com.google.common.collect.ImmutableSet;
import io.minio.MinioClient;
import io.minio.admin.MinioAdminClient;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import org.apache.tika.Tika;
import org.spring.boost.minio.hook.MinioHook;
import org.springframework.context.ApplicationEventPublisher;

@Builder
public class MinioTemplate {

	@NonNull private final MinioClient client;

	@NonNull private final MinioAdminClient adminClient;

	@NonNull private final String bucket;

	@NonNull private final ApplicationEventPublisher applicationEventPublisher;

	@Builder.Default
	private final Tika tika = new Tika();

	@Singular
	private final ImmutableSet<MinioHook> hooks;
}
