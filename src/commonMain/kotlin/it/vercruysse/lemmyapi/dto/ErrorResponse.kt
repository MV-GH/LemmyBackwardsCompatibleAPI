package it.vercruysse.lemmyapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ErrorResponse(
    @SerialName("error") val msg: String,
)
