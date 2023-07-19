package org.toolkit4J.libs.property

import java.io.File

object SystemProperties {
    val TEMPORARY_DIR = File(System.getProperty("java.io.tmpdir"))
    val CPU_COUNT = Runtime.getRuntime().availableProcessors()
}
