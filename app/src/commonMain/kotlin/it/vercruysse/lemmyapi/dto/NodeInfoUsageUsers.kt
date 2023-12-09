package it.vercruysse.lemmyapi.dto

import kotlinx.serialization.Serializable

@Serializable
data class NodeInfoUsageUsers(
    val activeHalfyear: Int,
    val activeMonth: Int,
    val total: Int,
)
