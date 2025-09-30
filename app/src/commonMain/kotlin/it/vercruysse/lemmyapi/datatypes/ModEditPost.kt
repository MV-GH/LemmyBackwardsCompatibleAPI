package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ModEditPost(
    val post_id: PostId,
    val nsfw: Boolean? = null,
    val tags: List<TagId>? = null,
) : DatatypeRoot
