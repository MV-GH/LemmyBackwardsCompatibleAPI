package dto

import kotlinx.serialization.Serializable

@Serializable
data class NodeInfoUsage(
    val localPosts: Int,
    val localComments: Int,
    val users: NodeInfoUsageUsers,
)
