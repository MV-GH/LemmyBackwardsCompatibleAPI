package it.vercruysse.lemmyapi.nodeinfo

import kotlinx.serialization.Serializable

@Serializable
internal data class NodeInfoLink(
    val rel: String,
    val href: String,
)
