package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class CustomEmojiKeyword(
    val custom_emoji_id: CustomEmojiId,
    val keyword: String,
) : DatatypeRoot, Identity {
    override val id: Long
        get() = custom_emoji_id
}
