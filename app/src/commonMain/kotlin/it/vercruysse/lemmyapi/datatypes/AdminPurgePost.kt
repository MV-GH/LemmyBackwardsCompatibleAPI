package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class AdminPurgePost(
    val id: Long,
    val admin_person_id: PersonId,
    val community_id: CommunityId,
    val reason: String? = null,
    val when_: String,
) : DatatypeRoot
