package org.spring.boost.minio

import io.minio.GetObjectResponse
import java.util.Optional

class MinioGetTemplate : MinioGet {
    override fun getObject(`object`: String?): GetObjectResponse {
        TODO("Not yet implemented")
    }

    override fun getObjectOptional(`object`: String?): Optional<GetObjectResponse> {
        TODO("Not yet implemented")
    }

    override fun getObjectByTag(tag: String?): Optional<GetObjectResponse> {
        TODO("Not yet implemented")
    }
}
