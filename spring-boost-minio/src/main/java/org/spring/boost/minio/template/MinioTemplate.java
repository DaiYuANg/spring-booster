/* (C)2024*/
package org.spring.boost.minio.template;

import com.google.common.collect.ImmutableSet;
import io.minio.MinioClient;
import io.minio.admin.MinioAdminClient;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.experimental.SuperBuilder;
import org.apache.tika.Tika;
import org.spring.boost.minio.hook.MinioHook;

@SuperBuilder
public class MinioTemplate {

	@NonNull @Getter
	protected final MinioClient client;

	@NonNull @Getter
	protected final MinioAdminClient adminClient;

	@NonNull protected final String bucket;

	@Builder.Default
	@Getter
	protected final Tika tika = new Tika();

	@Singular
	protected final ImmutableSet<MinioHook> hooks;

	protected boolean checkDuplicate;
}
