package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.CommunityVisibility
import it.vercruysse.lemmyapi.enums.VoteSettings
import kotlinx.serialization.Serializable

@Serializable
internal data class CreateCommunity(
    val name: String,
    val title: String? = null,
    val sidebar: String? = null,
    val summary: String? = null,
    val nsfw: Boolean? = null,
    val posting_restricted_to_mods: Boolean? = null,
    val discussion_languages: List<LanguageId>? = null,
    val visibility: CommunityVisibility? /* "public" | "unlisted" | "local_only_public" | "local_only_private" | "private" */ = null,
    val post_upvotes: VoteSettings? /* "all" | "local" | "subscribed" | "disable" */ = null,
    val post_downvotes: VoteSettings? /* "all" | "local" | "subscribed" | "disable" */ = null,
    val comment_upvotes: VoteSettings? /* "all" | "local" | "subscribed" | "disable" */ = null,
    val comment_downvotes: VoteSettings? /* "all" | "local" | "subscribed" | "disable" */ = null,
)
