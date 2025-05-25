package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: cursor changes

@CommonParcelize
@Serializable
data class ListPostLikes(
    val post_id: PostId,
    val page: Long? = null,
    val limit: Long? = null,
) : DatatypeRoot
