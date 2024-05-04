package it.vercruysse.lemmyapi

import io.ktor.client.*
import io.ktor.client.engine.*

fun LemmyApi.setDefaultClientConfig(block: HttpClientConfig<HttpClientEngineConfig>.() -> Unit) {
    defaultClient = defaultClient.config(block.unsafeCast<HttpClientConfig<*>.() -> Unit>())
}
