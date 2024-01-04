package org.spring.boost.minio.api

interface MinioAdmin {
    fun listBucketQuota(): Map<String, Long>
}
