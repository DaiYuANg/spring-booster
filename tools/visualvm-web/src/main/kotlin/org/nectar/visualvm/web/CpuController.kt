@file:OptIn(DelicateCoroutinesApi::class)

package org.nectar.visualvm.web

import com.fasterxml.jackson.databind.ObjectMapper
import io.javalin.http.sse.SseClient
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
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

fun sseBroadcast() {
    val processor = systemInfo.value.hardware.processor
    // 获取上一次 CPU 时间戳
    var prevTicks = processor.systemCpuLoadTicks
    val mapper = objectMapper.value
    // 使用协程
    GlobalScope.launch {
        while (true) {
            if (clients.isEmpty()) {
                continue
            }

            logger.atInfo().log("send:{}", clients)

            // 获取当前 CPU 时间戳
            val ticks = processor.systemCpuLoadTicks
            val cpuUsage = processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100.0
            val decimalFormat = DecimalFormat("#.##")
            val formattedCpuUsage = decimalFormat.format(cpuUsage)
            // 更新上一次 CPU 时间戳
            prevTicks = ticks
            val a =
                object {
                    val key = "cpu"
                    val load = formattedCpuUsage
                }
            val load = mapper.writeValueAsString(a)
            // 发送事件给所有客户端
            clients.forEach {
                it.sendEvent(load)
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
