package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

// TODO: changes mark read

@CommonParcelize
@Serializable
data class MarkManyPostsAsRead(
    val post_ids: List<PostId>,
): DatatypeRoot
