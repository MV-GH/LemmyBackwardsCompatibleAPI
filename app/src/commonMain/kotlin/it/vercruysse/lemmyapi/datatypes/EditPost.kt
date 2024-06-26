package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class EditPost(
    val post_id: PostId,
    val name: String? = null,
    val url: String? = null,
    val body: String? = null,
    val alt_text: String? = null,
    val nsfw: Boolean? = null,
    val language_id: LanguageId? = null,
    val custom_thumbnail: String? = null,
) : DatatypeRoot
