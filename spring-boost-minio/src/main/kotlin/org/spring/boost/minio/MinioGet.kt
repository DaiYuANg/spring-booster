package org.spring.boost.minio

import io.minio.GetObjectResponse
import io.minio.errors.ErrorResponseException
import io.minio.errors.InsufficientDataException
import io.minio.errors.InternalException
import io.minio.errors.InvalidResponseException
import io.minio.errors.ServerException
import io.minio.errors.XmlParserException
import java.io.IOException
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.util.Optional

interface MinioGet {
    @Throws(
        ServerException::class,
        InsufficientDataException::class,
        ErrorResponseException::class,
        IOException::class,
        NoSuchAlgorithmException::class,
        InvalidKeyException::class,
        InvalidResponseException::class,
        XmlParserException::class,
        InternalException::class,
    )
    fun getObject(`object`: String?): GetObjectResponse

    fun getObjectOptional(`object`: String?): Optional<GetObjectResponse>

    fun getObjectByTag(tag: String?): Optional<GetObjectResponse>
}
