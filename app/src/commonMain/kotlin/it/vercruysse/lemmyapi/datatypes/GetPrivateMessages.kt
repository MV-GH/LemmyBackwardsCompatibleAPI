package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class GetPrivateMessages(
    val unread_only: Boolean? = null,
    val page: Long? = null,
    val limit: Long? = null,
    val creator_id: PersonId? = null,
) : DatatypeRoot
