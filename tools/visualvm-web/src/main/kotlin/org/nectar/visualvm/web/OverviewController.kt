package org.nectar.visualvm.web

import io.javalin.http.Context
import org.slf4j.LoggerFactory
import oshi.SystemInfo
import java.lang.invoke.MethodHandles

private val logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
private val systemInfo = inject<SystemInfo>()

fun querySystemService(ctx: Context) {
    val services = systemInfo.value.operatingSystem.services

    ctx.json(services)
}

fun queryProcessor(ctx: Context) {
    val processId = ctx.queryParam("processId")

    processId?.toInt()?.let {
        val process = systemInfo.value.operatingSystem.getProcess(it)
        ctx.json(process)
    }
}

fun querySystemEnvironment(ctx: Context) {
    val data =
        object {
            val env = System.getenv()
            val properties = System.getProperties()
            val version = Runtime.version()
        }
    ctx.json(data)
}
