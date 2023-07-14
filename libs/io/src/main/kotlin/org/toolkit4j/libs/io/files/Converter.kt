package org.toolkit4j.libs.io.files

import java.io.File
import java.util.*
import lombok.SneakyThrows
import org.apache.commons.io.FileUtils

@SneakyThrows
fun base64ToFile(base64: String?, target: String?): File? {
  val targetFile = target?.let { File(it) }
  FileUtils.writeByteArrayToFile(targetFile, Base64.getDecoder().decode(base64))
  return targetFile
}

@SneakyThrows
fun fileToBase64(target: File?): String {
  return Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(target))
}
