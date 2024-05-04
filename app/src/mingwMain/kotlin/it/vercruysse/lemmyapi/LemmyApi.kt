package it.vercruysse.lemmyapi

import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.winhttp.WinHttpClientEngineConfig

fun LemmyApi.setDefaultClientConfig(block: HttpClientConfig<WinHttpClientEngineConfig>.() -> Unit) {
    @Suppress("UNCHECKED_CAST")
    defaultClient = defaultClient.config(block as HttpClientConfig<*>.() -> Unit)
}
