package dto

import kotlinx.serialization.Serializable

@Serializable
data class NodeInfoSoftware(val name: String, val version: String)
