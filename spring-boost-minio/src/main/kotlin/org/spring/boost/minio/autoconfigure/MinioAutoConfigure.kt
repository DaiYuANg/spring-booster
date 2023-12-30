package org.spring.boost.minio.autoconfigure

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties

@AutoConfiguration
@EnableConfigurationProperties(MinioConfigurationProperties::class)
class MinioAutoConfigure {

}