package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class GetCaptchaResponse(
    val ok: CaptchaResponse? = null,
) : DatatypeRoot
