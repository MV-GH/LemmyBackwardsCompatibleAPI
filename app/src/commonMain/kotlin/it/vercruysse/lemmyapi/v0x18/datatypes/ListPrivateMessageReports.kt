package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ListPrivateMessageReports(
    val page: Int? = null,
    val limit: Int? = null,
    val unresolved_only: Boolean? = null,
    val auth: String,
)
