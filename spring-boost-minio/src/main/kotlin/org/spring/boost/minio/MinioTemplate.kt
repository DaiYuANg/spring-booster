package org.spring.boost.minio

import io.minio.MinioClient
import io.minio.PutObjectArgs
import io.minio.errors.*
import jdk.jfr.ContentType
import org.apache.commons.io.FileUtils
import org.apache.tika.Tika
import org.spring.boost.minio.check.PreCheckerChain
import org.spring.boost.minio.path.PathRuler
import org.springframework.context.ApplicationEventPublisher
import org.springframework.util.DigestUtils
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.io.InputStream
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException

data class MinioTemplate @JvmOverloads constructor(
    private val client: MinioClient,
    private val bucket: String,
    private val tika: Tika = Tika(),
    private val publisher: ApplicationEventPublisher,
    private val checkerChain: PreCheckerChain
) {

    fun put(file: MultipartFile, name: String) {
        val stream = file.inputStream
        val contentBytes = stream.readBytes()
        val contentType = tika.detect(contentBytes.inputStream())
        val md5 = DigestUtils.md5DigestAsHex(contentBytes.inputStream())
    }

    @Throws(
        ErrorResponseException::class,
        InsufficientDataException::class,
        InternalException::class,
        InvalidKeyException::class,
        InvalidResponseException::class,
        IOException::class,
        NoSuchAlgorithmException::class,
        ServerException::class,
        XmlParserException::class
    )
    fun create(stream: InputStream, name: String, contentType: String, pathRuler: Collection<PathRuler>): String {
        val finalPath = "${
            pathRuler.map {
                "${it.path()}/"
            }
        }$name"
        PutObjectArgs.builder()
            .stream(stream, stream.available().toLong(), -1)
            .`object`(finalPath)
            .build()
            .let(client::putObject)
        return name
    }
}