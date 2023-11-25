package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CaptchaResponse(
    val png: String,
    val wav: String,
    val uuid: String,
)
