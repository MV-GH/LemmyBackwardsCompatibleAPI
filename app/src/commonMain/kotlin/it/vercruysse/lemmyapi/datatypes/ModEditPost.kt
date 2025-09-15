package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.PostId
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.TagId
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ModEditPost(
    val post_id: PostId,
    val nsfw: Boolean? = null,
    val tags: List<TagId>? = null,
) : DatatypeRoot
