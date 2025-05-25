package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO changes MarkPostAsRead amount list

@CommonParcelize
@Serializable
data class MarkPostAsRead(
    val post_ids: List<PostId>,
    val read: Boolean,
) : DatatypeRoot
