package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class CustomEmojiResponse(
    val custom_emoji: CustomEmojiView,
) : DatatypeRoot
