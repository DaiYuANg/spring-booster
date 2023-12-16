package org.nectar.visualvm.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.javalin.Javalin
import io.javalin.json.JavalinJackson
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.environmentProperties
import org.koin.logger.slf4jLogger
import oshi.SystemInfo

val rootModule =
    module {
        single {
            HardwareService()
            Javalin.create()
        }
        single {
            SystemInfo()
        }
        single<ObjectMapper> {
            val objectMapper = ObjectMapper()
            objectMapper.registerKotlinModule()
        }
        single {
            Javalin.create {
                it.jsonMapper(
                    JavalinJackson().updateMapper {
                        get<ObjectMapper>()
                    },
                )
            }
        }
    }

fun main() {
    val app =
        startKoin {
            slf4jLogger()
            modules(rootModule)
            environmentProperties()
            createEagerInstances()
        }
    val javalin = app.koin.get<Javalin>(Javalin::class)

    javalin.start()
        .get("/", ::querySystemService)
        .sse("/cpu/load", ::cpuReadTimeLoad)
        .get("/process", ::queryProcessor)
        .get("/environment", ::querySystemEnvironment)

    sseBroadcast()
}
