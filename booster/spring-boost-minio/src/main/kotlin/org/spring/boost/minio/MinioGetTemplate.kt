package org.spring.boost.minio

import io.minio.GetObjectResponse
import org.spring.boost.minio.api.MinioGet
import java.util.Optional

class MinioGetTemplate
    @JvmOverloads
    constructor(
        templateArg: MinioTemplateArgument = MinioTemplateArgument.builder().build(),
    ) : MinioGet, BaseTemplate(templateArg) {
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
