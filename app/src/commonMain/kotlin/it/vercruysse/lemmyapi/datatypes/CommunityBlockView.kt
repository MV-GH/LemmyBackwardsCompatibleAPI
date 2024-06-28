package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class CommunityBlockView(
    val person: Person,
    val community: Community,
) : DatatypeRoot
