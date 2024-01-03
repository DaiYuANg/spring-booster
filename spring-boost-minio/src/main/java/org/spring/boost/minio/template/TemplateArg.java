/* (C)2024*/
package org.spring.boost.minio.template;

import com.google.common.collect.ImmutableSet;
import io.minio.MinioClient;
import io.minio.admin.MinioAdminClient;
import lombok.*;
import org.apache.tika.Tika;
import org.spring.boost.minio.hook.MinioHook;

@Builder
@ToString
public class TemplateArg {
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

	@Builder.Default
	protected boolean checkDuplicate = false;
}
