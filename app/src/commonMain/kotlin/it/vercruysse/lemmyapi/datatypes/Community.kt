package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import it.vercruysse.lemmyapi.dto.CommunityVisibility
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// Changed

@CommonParcelize
@Serializable
data class Community(
    override val id: CommunityId,
    val name: String,
    val title: String,
    val description: String? = null,
    val removed: Boolean,
    val published: String,
    val updated: String? = null,
    val deleted: Boolean,
    val nsfw: Boolean,
    val actor_id: String,
    val local: Boolean,
    val icon: String? = null,
    val banner: String? = null,
    val hidden: Boolean,
    val posting_restricted_to_mods: Boolean,
    val instance_id: InstanceId,
    val visibility: CommunityVisibility /* "Public" | "LocalOnly" */,
) : DatatypeRoot, Identity
