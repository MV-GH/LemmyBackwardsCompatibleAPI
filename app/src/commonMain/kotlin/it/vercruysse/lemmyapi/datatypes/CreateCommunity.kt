package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.CommunityVisibility
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
// TODO: remove icon & banner
data class CreateCommunity(
    val name: String,
    val title: String,
    val sidebar: String? = null,
    val summary: String? = null,
    /** Removed in 1.0.0 */
    val icon: String? = null,
    /** Removed in 1.0.0 */
    val banner: String? = null,
    val nsfw: Boolean? = null,
    val posting_restricted_to_mods: Boolean? = null,
    val discussion_languages: List<LanguageId>? = null,
    val visibility: CommunityVisibility? /* "Public" | "Unlisted" | "LocalOnlyPublic" | "LocalOnlyPrivate" | "Private" */ = null,
) : DatatypeRoot
