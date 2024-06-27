package it.vercruysse.lemmyapi.v0.x19.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CaptchaResponse(
    val png: String,
    val wav: String,
    val uuid: String,
)
