package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class GetCommunity(
    val id: CommunityId? = null,
    val name: String? = null,
) : DatatypeRoot
