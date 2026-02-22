package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class MarkManyPostsAsRead(
    val post_ids: List<PostId>,
    val read: Boolean,
) : DatatypeRoot
