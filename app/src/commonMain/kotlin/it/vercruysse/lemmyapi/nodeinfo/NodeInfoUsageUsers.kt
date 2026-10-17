package it.vercruysse.lemmyapi.nodeinfo

import kotlinx.serialization.Serializable

@Serializable
data class NodeInfoUsageUsers(
    val activeHalfyear: Int? = null,
    val activeMonth: Int? = null,
    val total: Int? = null,
)
