package it.vercruysse.lemmyapi

import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.cio.CIOEngineConfig

fun LemmyApi.setDefaultClientConfig(block: HttpClientConfig<CIOEngineConfig>.() -> Unit) {
    @Suppress("UNCHECKED_CAST")
    defaultClient = defaultClient.config(block as HttpClientConfig<*>.() -> Unit)
}
