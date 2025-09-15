package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ListMultiCommunities(
    val creator_id: PersonId? = null,
    val followed_only: Boolean? = null,
)
