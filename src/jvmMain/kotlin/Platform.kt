@file:JvmName("PlatformJava")

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*

actual val baseClient = HttpClient(OkHttp)
