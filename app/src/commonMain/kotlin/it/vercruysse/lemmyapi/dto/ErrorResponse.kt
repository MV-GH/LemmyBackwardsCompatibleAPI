package it.vercruysse.lemmyapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ErrorResponse(@SerialName("error") val id: String, @SerialName("message") val message: String? = null)
