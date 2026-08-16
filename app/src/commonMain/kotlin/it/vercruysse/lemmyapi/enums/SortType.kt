package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import io.github.z4kn4fein.semver.toVersion
import it.vercruysse.lemmyapi.MINIMUM_API_VERSION
import it.vercruysse.lemmyapi.V0_18_0
import it.vercruysse.lemmyapi.V0_19_0
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SortType(override val minimumVersion: Version = MINIMUM_API_VERSION, override val maximumVersion: Version? = null) :
    VersionTracker {
    @SerialName("active")
    Active,

    @SerialName("hot")
    Hot,

    @SerialName("new")
    New,

    @SerialName("old")
    Old,

    @SerialName("top_day")
    TopDay,

    @SerialName("top_week")
    TopWeek,

    @SerialName("top_month")
    TopMonth,

    @SerialName("top_year")
    TopYear,

    @SerialName("top_all")
    TopAll,

    @SerialName("most_comments")
    MostComments,

    @SerialName("new_comments")
    NewComments,

    @SerialName("top_hour")
    TopHour(V0_18_0),

    @SerialName("top_six_hour")
    TopSixHour(V0_18_0),

    @SerialName("top_twelve_hour")
    TopTwelveHour(V0_18_0),

    @SerialName("top_three_months")
    TopThreeMonths("0.18.1".toVersion()),

    @SerialName("top_six_months")
    TopSixMonths("0.18.1".toVersion()),

    @SerialName("top_nine_months")
    TopNineMonths("0.18.1".toVersion()),

    @SerialName("controversial")
    Controversial(V0_19_0),

    @SerialName("scaled")
    Scaled(V0_19_0),
}
