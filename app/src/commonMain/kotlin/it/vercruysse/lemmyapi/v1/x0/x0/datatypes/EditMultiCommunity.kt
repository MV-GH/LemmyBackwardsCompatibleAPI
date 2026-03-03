package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class EditMultiCommunity(
    val id: MultiCommunityId,
    val title: String? = null,
    val summary: String? = null,
    val deleted: Boolean? = null,
)
