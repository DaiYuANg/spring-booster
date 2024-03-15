package org.spring.boost.minio

import com.google.common.collect.ImmutableSet
import io.minio.MinioClient
import io.minio.admin.MinioAdminClient
import okhttp3.OkHttpClient
import okhttp3.Request
import org.apache.tika.Tika
import org.spring.boost.minio.hook.MinioHook
import org.spring.boost.minio.properties.MinioClientConfig

open class BaseTemplate(
    templateArg: MinioTemplateArgument,
){
    val client: MinioClient by lazy { templateArg.client }

    val adminClient: MinioAdminClient by lazy { templateArg.adminClient }

    val bucket: String by lazy { templateArg.bucket }

    val tika: Tika by lazy { templateArg.tika }

    val hooks: ImmutableSet<MinioHook> by lazy { templateArg.hooks }

    val checkDuplicate: Boolean by lazy { templateArg.isCheckDuplicate }

    val config: MinioClientConfig by lazy { templateArg.config }

    val httpClient: OkHttpClient by lazy { templateArg.okHttpClient }

    private val healthPath: String = "/minio/health/live"

    fun ping(): Boolean {
        val url = "${config.endpoint.removeSuffix("/")}$healthPath"
        val req = Request.Builder().get().url(url).build()
        return httpClient.newCall(req).execute().code == 200
    }
}
