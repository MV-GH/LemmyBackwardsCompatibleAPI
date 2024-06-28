package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class CaptchaResponse(
    val png: String,
    val wav: String,
    val uuid: String,
) : DatatypeRoot
