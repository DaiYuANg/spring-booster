package org.spring.boost.minio

import org.spring.boost.minio.api.MinioAdmin

class
MinioAdminTemplate@JvmOverloads
    constructor(
        templateArg: MinioTemplateArgument = MinioTemplateArgument.builder().build(),
    ) : BaseTemplate(templateArg), MinioAdmin {
        override fun listBucketQuota(): Map<String, Long> {
            return client.listBuckets().associateBy({ it.name() }) { adminClient.getBucketQuota(it.name()) }
        }
    }
