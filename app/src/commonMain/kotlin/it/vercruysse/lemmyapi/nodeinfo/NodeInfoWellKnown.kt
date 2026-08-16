package it.vercruysse.lemmyapi.nodeinfo

import kotlinx.serialization.Serializable

@Serializable
internal data class NodeInfoWellKnown(
    val links: List<NodeInfoLink> = emptyList(),
)
