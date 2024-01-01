package org.spring.boost.minio.check

import java.io.InputStream

data class PreCheckerChain @JvmOverloads constructor(
    private val checks: MutableSet<PreUploadCheck> = mutableSetOf()
) : Set<PreUploadCheck> by checks, PreUploadCheck {
    override fun performCheck(stream: InputStream, name: String, contentType: String): String? {
        return checks
            .asSequence()
            .map { it.performCheck(InputStream.nullInputStream(), name, contentType) }
            .firstOrNull { it != null }
    }
}