package org.nectar.visualvm.web

import com.fasterxml.jackson.databind.ObjectMapper
import io.javalin.http.sse.SseClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import oshi.SystemInfo
import java.lang.invoke.MethodHandles
import java.text.DecimalFormat
import java.util.concurrent.ConcurrentLinkedQueue

val clients = ConcurrentLinkedQueue<SseClient>()
private val logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
private val systemInfo = inject<SystemInfo>()
private val objectMapper = inject<ObjectMapper>()
val sseScope = CoroutineScope(Dispatchers.Default)

fun sseBroadcast() {
    val processor = systemInfo.value.hardware.processor
    // 获取上一次 CPU 时间戳
    var prevTicks = processor.systemCpuLoadTicks
    // 使用协程
    sseScope.launch {
        while (true) {
            if (clients.isNotEmpty()) {
                try {
                    // 获取当前 CPU 时间戳
                    val ticks = processor.systemCpuLoadTicks
                    val cpuUsage = processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100.0
                    val formattedCpuUsage = DecimalFormat("#.##").format(cpuUsage)
                    // 更新上一次 CPU 时间戳
                    prevTicks = ticks
                    val data = mapOf("key" to "cpu", "load" to formattedCpuUsage)
                    val load = objectMapper.value.writeValueAsString(data)

                    // 一次性发送数据给所有客户端
                    val allClients = ArrayList(clients)
                    allClients.forEach {
                        it.sendEvent(load)
                    }
                } catch (e: Exception) {
                    logger.error("Error during SSE broadcast", e)
                }
            }

            delay(1000) // 延迟一秒后再次循环
        }
    }
}

fun cpuReadTimeLoad(client: SseClient) {
    clients.add(client)
    client.keepAlive()
    client.onClose { clients.remove(client) }
}
