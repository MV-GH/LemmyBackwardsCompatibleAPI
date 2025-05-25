package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: removed

@CommonParcelize
@Serializable
data class ListPostReports(
    val page: Long? = null,
    val limit: Long? = null,
    val unresolved_only: Boolean? = null,
    val community_id: CommunityId? = null,
    val post_id: PostId? = null,
) : DatatypeRoot
