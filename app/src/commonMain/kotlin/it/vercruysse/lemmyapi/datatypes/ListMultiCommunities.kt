package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ListMultiCommunities(
    val creator_id: PersonId? = null,
    val followed_only: Boolean? = null,
) : DatatypeRoot
