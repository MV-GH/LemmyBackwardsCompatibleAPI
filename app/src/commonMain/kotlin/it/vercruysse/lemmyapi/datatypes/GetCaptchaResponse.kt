package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetCaptchaResponse(
    val ok: CaptchaResponse? = null,
)
