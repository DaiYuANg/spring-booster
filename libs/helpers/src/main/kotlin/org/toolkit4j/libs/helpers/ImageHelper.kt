@file:OptIn(ExperimentalEncodingApi::class)

package org.toolkit4j.libs.helpers

import java.io.File
import java.io.FileOutputStream
import java.nio.file.Path
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

fun base64ToImage(base64: String, outputPath: Path): File {
    val decodedImageBytes = Base64.decode(base64)
    FileOutputStream(outputPath.toFile()).use { outputStream ->
        outputStream.write(decodedImageBytes)
    }
    return outputPath.toFile();
}