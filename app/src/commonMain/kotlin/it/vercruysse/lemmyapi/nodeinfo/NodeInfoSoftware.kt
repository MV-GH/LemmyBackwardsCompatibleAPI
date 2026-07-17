package it.vercruysse.lemmyapi.nodeinfo

import kotlinx.serialization.Serializable

@Serializable
data class NodeInfoSoftware(val name: String, val version: String)
