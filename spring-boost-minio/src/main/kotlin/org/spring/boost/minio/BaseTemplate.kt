package org.spring.boost.minio

import com.google.common.collect.ImmutableSet
import io.minio.MinioClient
import io.minio.admin.MinioAdminClient
import org.apache.tika.Tika
import org.spring.boost.minio.hook.MinioHook

open class BaseTemplate(
    templateArg: MinioTemplateArgument,
) {
    protected val client: MinioClient = templateArg.client
    protected val adminClient: MinioAdminClient = templateArg.adminClient
    protected val bucket: String = templateArg.bucket
    protected val tika: Tika = templateArg.tika
    protected val hooks: ImmutableSet<MinioHook> = templateArg.hooks
    protected val checkDuplicate = templateArg.isCheckDuplicate
}