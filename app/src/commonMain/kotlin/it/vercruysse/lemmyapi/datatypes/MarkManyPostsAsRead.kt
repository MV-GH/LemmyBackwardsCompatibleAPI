package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class MarkManyPostsAsRead(
    val post_ids: List<PostId>,
    val read: Boolean,
) : DatatypeRoot
