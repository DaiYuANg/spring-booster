package org.spring.boost.minio.check

import java.io.InputStream

interface PreUploadCheck {
    @Throws(PreUploadCheckException::class)
    fun performCheck(stream: InputStream, name: String, contentType: String): String?
}

class PreUploadCheckException(message: String) : RuntimeException(message)
