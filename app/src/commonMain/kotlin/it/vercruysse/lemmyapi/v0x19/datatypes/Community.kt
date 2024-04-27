package it.vercruysse.lemmyapi.v0x19.datatypes

import it.vercruysse.lemmyapi.dto.CommunityVisibility
import kotlinx.serialization.Serializable

@Serializable
data class Community(
    val id: CommunityId,
    val name: String,
    val title: String,
    val description: String? = null,
    val removed: Boolean,
    val published: String,
    val updated: String? = null,
    val deleted: Boolean,
    val nsfw: Boolean,
    val actor_id: String,
    val local: Boolean,
    val icon: String? = null,
    val banner: String? = null,
    val hidden: Boolean,
    val posting_restricted_to_mods: Boolean,
    val instance_id: InstanceId,
    val visibility: CommunityVisibility? = null /* "Public" | "LocalOnly" */, // Added in 0.19.4
)
