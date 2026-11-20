package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.MINIMUM_API_VERSION
import it.vercruysse.lemmyapi.V1_0_0
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Sort for [it.vercruysse.lemmyapi.datatypes.ListCommunities].
 *
 * Before 1.0 communities are sorted with the post sort; each entry is sent as the post sort that
 * orders communities the same way. Entries added in 1.0 are not sent pre 1.0 (the server default is used).
 */
@Serializable
enum class CommunitySortType(override val minimumVersion: Version = MINIMUM_API_VERSION, override val maximumVersion: Version? = null) :
    VersionTracker {
    @SerialName("active_six_months")
    ActiveSixMonths,

    @SerialName("active_monthly")
    ActiveMonthly,

    @SerialName("active_weekly")
    ActiveWeekly,

    @SerialName("active_daily")
    ActiveDaily,

    @SerialName("hot")
    Hot,

    @SerialName("new")
    New,

    @SerialName("old")
    Old,

    @SerialName("name_asc")
    NameAsc(V1_0_0),

    @SerialName("name_desc")
    NameDesc(V1_0_0),

    @SerialName("comments")
    Comments,

    @SerialName("posts")
    Posts(V1_0_0),

    @SerialName("subscribers")
    Subscribers,

    @SerialName("subscribers_local")
    SubscribersLocal(V1_0_0),
}
