package org.spring.boost.minio.api

import io.minio.ObjectWriteResponse
import io.minio.messages.Tags
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.InputStream

interface MinioCreate {
    /**
     *
     */
    fun createObject(
        inputStream: InputStream,
        bucket: String,
        contentType: String,
        name: String,
        tags: MutableMap<String, String>,
    ): ObjectWriteResponse

    fun createObject(
        stream: InputStream,
        contentType: String,
        name: String,
        tags: MutableMap<String, String>?,
    ): ObjectWriteResponse

    fun createObject(
        stream: InputStream,
        name: String,
        tags: MutableMap<String, String>?,
    ): ObjectWriteResponse

    fun createObject(
        data: ByteArray,
        bucket: String,
        contentType: String,
        name: String,
        tags: MutableMap<String, String>?,
    ): ObjectWriteResponse

    fun createObject(
        data: ByteArray,
        bucket: String,
        contentType: String,
        name: String,
        tags: Tags,
    ): ObjectWriteResponse

    fun createObject(
        data: ByteArray,
        bucket: String,
        name: String,
        tags: Tags,
    ): ObjectWriteResponse

    fun createObject(
        data: ByteArray,
        name: String,
        tags: Tags,
    ): ObjectWriteResponse

    fun createObject(
        data: ByteArray,
        name: String,
    ): ObjectWriteResponse

    fun createObject(
        file: MultipartFile,
        bucket: String,
        contentType: String,
        name: String,
        tags: MutableMap<String, String>?,
    ): ObjectWriteResponse

    fun createObject(
        file: MultipartFile,
        contentType: String,
        name: String,
        tags: MutableMap<String, String>,
    ): ObjectWriteResponse

    fun createObject(
        file: MultipartFile,
        name: String,
        tags: MutableMap<String, String>,
    ): ObjectWriteResponse

    fun createObject(
        file: MultipartFile,
        name: String,
    ): ObjectWriteResponse

    fun createObject(
        file: File,
        contentType: String,
        name: String,
        tags: MutableMap<String, String>?,
    ): ObjectWriteResponse

    fun createObject(
        file: File,
        name: String,
        tags: MutableMap<String, String>,
    ): ObjectWriteResponse

    fun createObject(
        file: File,
        name: String,
    ): ObjectWriteResponse
}
