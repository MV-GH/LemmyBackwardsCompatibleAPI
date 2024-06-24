package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListPrivateMessageReports(
    val page: Long? = null,
    val limit: Long? = null,
    val unresolved_only: Boolean? = null,
)
