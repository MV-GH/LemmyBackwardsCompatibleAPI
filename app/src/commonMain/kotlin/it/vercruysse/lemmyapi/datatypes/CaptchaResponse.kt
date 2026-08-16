package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CaptchaResponse(
    val png: String,
    val wav: String,
    val uuid: String,
) : DatatypeRoot
