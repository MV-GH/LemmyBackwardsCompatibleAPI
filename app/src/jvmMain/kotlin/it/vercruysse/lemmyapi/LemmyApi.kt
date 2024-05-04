package it.vercruysse.lemmyapi

import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.okhttp.OkHttpConfig

fun LemmyApi.setDefaultClientConfig(block: HttpClientConfig<OkHttpConfig>.() -> Unit) {
    defaultClient = defaultClient.config(block as HttpClientConfig<*>.() -> Unit)
}
