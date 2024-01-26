package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ListRegistrationApplications(
    val unread_only: Boolean? = null,
    val page: Long? = null,
    val limit: Long? = null,
    val auth: String,
)
