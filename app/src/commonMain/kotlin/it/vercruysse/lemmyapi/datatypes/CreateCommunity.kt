package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.CommunityVisibility
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class CreateCommunity(
    val name: String,
    val title: String,
    val description: String? = null,
    val icon: String? = null,
    val banner: String? = null,
    val nsfw: Boolean? = null,
    val posting_restricted_to_mods: Boolean? = null,
    val discussion_languages: List<LanguageId>? = null,
    val visibility: CommunityVisibility? /* "Public" | "LocalOnly" */ = null,
) : DatatypeRoot
