package it.vercruysse.lemmyapi.dto

import kotlinx.serialization.Serializable

@Serializable
data class NodeInfo(
    val version: String,
    val software: NodeInfoSoftware,
    val protocols: List<String> = emptyList(),
    val openRegistrations: Boolean,
    val usage: NodeInfoUsage,
)
