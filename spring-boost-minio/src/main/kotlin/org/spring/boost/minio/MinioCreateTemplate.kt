package org.spring.boost.minio

import io.minio.ObjectWriteResponse
import io.minio.messages.Tags
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.InputStream

class MinioCreateTemplate : MinioCreate {
    override fun createObject(
        inputStream: InputStream,
        bucket: String,
        contentType: String,
        name: String,
        tags: MutableMap<String, String>,
    ): ObjectWriteResponse {
        TODO("Not yet implemented")
    }

    override fun createObject(
        stream: InputStream,
        contentType: String,
        name: String,
        tags: MutableMap<String, String>?,
    ): ObjectWriteResponse {
        TODO("Not yet implemented")
    }

    override fun createObject(
        stream: InputStream,
        name: String,
        tags: MutableMap<String, String>?,
    ): ObjectWriteResponse {
        TODO("Not yet implemented")
    }

    override fun createObject(
        data: ByteArray,
        bucket: String,
        contentType: String,
        name: String,
        tags: MutableMap<String, String>?,
    ): ObjectWriteResponse {
        TODO("Not yet implemented")
    }

    override fun createObject(
        data: ByteArray,
        bucket: String,
        contentType: String,
        name: String,
        tags: Tags,
    ): ObjectWriteResponse {
        TODO("Not yet implemented")
    }

    override fun createObject(
        data: ByteArray,
        bucket: String,
        name: String,
        tags: Tags,
    ): ObjectWriteResponse {
        TODO("Not yet implemented")
    }

    override fun createObject(
        data: ByteArray,
        name: String,
        tags: Tags,
    ): ObjectWriteResponse {
        TODO("Not yet implemented")
    }

    override fun createObject(
        data: ByteArray,
        name: String,
    ): ObjectWriteResponse {
        TODO("Not yet implemented")
    }

    override fun createObject(
        file: MultipartFile,
        bucket: String,
        contentType: String,
        name: String,
        tags: MutableMap<String, String>?,
    ): ObjectWriteResponse {
        TODO("Not yet implemented")
    }

    override fun createObject(
        file: MultipartFile,
        contentType: String,
        name: String,
        tags: MutableMap<String, String>,
    ): ObjectWriteResponse {
        TODO("Not yet implemented")
    }

    override fun createObject(
        file: MultipartFile,
        name: String,
        tags: MutableMap<String, String>,
    ): ObjectWriteResponse {
        TODO("Not yet implemented")
    }

    override fun createObject(
        file: MultipartFile,
        name: String,
    ): ObjectWriteResponse {
        TODO("Not yet implemented")
    }

    override fun createObject(
        file: File,
        contentType: String,
        name: String,
        tags: MutableMap<String, String>?,
    ): ObjectWriteResponse {
        TODO("Not yet implemented")
    }

    override fun createObject(
        file: File,
        name: String,
        tags: MutableMap<String, String>,
    ): ObjectWriteResponse {
        TODO("Not yet implemented")
    }

    override fun createObject(
        file: File,
        name: String,
    ): ObjectWriteResponse {
        TODO("Not yet implemented")
    }
}
