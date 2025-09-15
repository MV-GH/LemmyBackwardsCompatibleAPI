package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class UpdateMultiCommunity(
    val id: MultiCommunityId,
    val title: String? = null,
    val description: String? = null,
    val deleted: Boolean? = null,
)
