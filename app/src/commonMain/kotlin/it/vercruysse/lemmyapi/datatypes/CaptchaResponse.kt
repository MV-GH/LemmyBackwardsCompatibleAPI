package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CaptchaResponse(
    val png: String,
    val wav: String,
    val uuid: String,
)
