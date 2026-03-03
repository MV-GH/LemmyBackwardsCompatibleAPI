package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class EditMultiCommunity(
    val id: MultiCommunityId,
    val title: String? = null,
    val summary: String? = null,
    val deleted: Boolean? = null,
) : DatatypeRoot
