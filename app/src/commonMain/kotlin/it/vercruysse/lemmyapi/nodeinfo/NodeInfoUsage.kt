package it.vercruysse.lemmyapi.nodeinfo

import kotlinx.serialization.Serializable

@Serializable
data class NodeInfoUsage(
    val localPosts: Int? = null,
    val localComments: Int? = null,
    val users: NodeInfoUsageUsers,
)
