package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class MultiCommunity(
    val id: MultiCommunityId,
    val creator_id: PersonId,
    val instance_id: InstanceId,
    val name: String,
    val title: String? = null,
    val description: String? = null,
    val local: Boolean,
    val deleted: Boolean,
    val ap_id: DbUrl,
    val published_at: String,
    val updated_at: String? = null,
)
