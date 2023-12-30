package org.spring.boost.minio.autoconfigure

import org.springframework.boot.context.properties.ConfigurationProperties

data class MinioClientConfig(
    private var endpoint: String? = null,

    private val accessKey: String? = null,

    private val secretKey: String? = null,

    private val defaultBucket: String? = null,
)

@ConfigurationProperties("spring.boost")
data class MinioConfigurationProperties(
    private var endpoint: String? = null,

    private val accessKey: String? = null,

    private val secretKey: String? = null,

    private val defaultBucket: String? = null,

    private val clients:Map<String,MinioClientConfig>? = null
) {
}