package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
external internal data class `T$130`(
    val reason: String? = null,
)

external internal data class `T$162`(
    val error: dynamic /* "InvalidCommunity" | "CannotCreatePostOrCommentInDeletedOrRemovedCommunity" | "CannotReceivePage" | "OnlyLocalAdminCanRemoveCommunity" | "OnlyLocalAdminCanRestoreCommunity" | "PostIsLocked" | `T$0`? | "InvalidVoteValue" | "PageDoesNotSpecifyCreator" | "CouldntGetComments" | "CouldntGetPosts" | "FederationDisabled" | `T$1`? | `T$2`? | "FederationDisabledByStrictAllowList" | "ContradictingFilters" | "UrlWithoutDomain" | "InboxTimeout" | "CantDeleteSite" | "ObjectIsNotPublic" | "ObjectIsNotPrivate" | "PlatformLackingPrivateCommunitySupport" | "Unreachable" */ = null,
)
