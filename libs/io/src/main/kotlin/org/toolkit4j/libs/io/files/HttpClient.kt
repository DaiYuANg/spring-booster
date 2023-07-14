package org.toolkit4j.libs.io.files

import java.io.File
import jdk.jfr.Experimental
import lombok.Getter
import lombok.SneakyThrows
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull

@Experimental
@Getter
class HttpClient {
  private val mediaType: MediaType? = "application/json; charset=utf-8".toMediaTypeOrNull()
  private val client: OkHttpClient
  private var cacheSize = 10 * 1024 * 1024
  private var cache = Cache(File(System.getProperty("java.io.tmpdir")), cacheSize.toLong())

  constructor(builder: OkHttpClient.Builder) {
    client = builder.cache(cache).build()
  }

  constructor(builder: OkHttpClient.Builder, cacheSize: Int) {
    this.cacheSize = cacheSize
    client = builder.cache(cache).build()
  }

  constructor(builder: OkHttpClient.Builder, cache: Cache) {
    client = builder.cache(cache).build()
    this.cache = cache
  }

  @SneakyThrows
  operator fun get(reqBuilder: Request.Builder): Response {
    val req: Request = reqBuilder.get().build()
    return exec(req)
  }

  operator fun get(url: String?): Response {
    val req: Request? = url?.let { Request.Builder().url(it).get().build() }
    return exec(req)
  }

  @SneakyThrows
  fun exec(req: Request?): Response {
    client.newCall(req!!).execute().use { resp ->
      return resp
    }
  }

  fun postJson(reqBuilder: Request.Builder, json: String?): Response {
    val body: RequestBody? = json?.let { RequestBody.create(mediaType, it) }
    val req: Request? = body?.let { reqBuilder.post(it).build() }
    return exec(req)
  }
}
