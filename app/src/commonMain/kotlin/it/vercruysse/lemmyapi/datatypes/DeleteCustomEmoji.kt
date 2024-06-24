package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class DeleteCustomEmoji(
    val id: CustomEmojiId,
)
