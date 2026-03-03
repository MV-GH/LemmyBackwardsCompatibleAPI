package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.PostId
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class MarkPostAsRead(
    val post_id: PostId,
    val read: Boolean,
) : DatatypeRoot
