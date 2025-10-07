package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminBan(
    val id: AdminBanId,
    val mod_person_id: PersonId,
    val other_person_id: PersonId,
    val reason: String,
    val banned: Boolean,
    val expires_at: String? = null,
    val published_at: String,
    val instance_id: InstanceId,
)
