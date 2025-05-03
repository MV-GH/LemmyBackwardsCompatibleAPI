package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class UpdateCommunityTag(
    val tag_id: TagId,
    val display_name: String,
)
