package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import io.github.z4kn4fein.semver.toVersion
import it.vercruysse.lemmyapi.MINIMUM_API_VERSION
import it.vercruysse.lemmyapi.V0_18_0
import it.vercruysse.lemmyapi.V0_19_0
import kotlinx.serialization.Serializable

// TODO: fix
// now only "Active" | "Hot" | "New" | "Old" | "Top" | "MostComments" | "NewComments" | "Controversial" | "Scaled"

@Serializable
enum class SortType(override val minimumVersion: Version = MINIMUM_API_VERSION, override val maximumVersion: Version? = null) :
    VersionTracker {
    Active,
    Hot,
    New,
    Old,
    TopDay,
    TopWeek,
    TopMonth,
    TopYear,
    TopAll,
    MostComments,
    NewComments,
    TopHour(V0_18_0),
    TopSixHour(V0_18_0),
    TopTwelveHour(V0_18_0),
    TopThreeMonths("0.18.1".toVersion()),
    TopSixMonths("0.18.1".toVersion()),
    TopNineMonths("0.18.1".toVersion()),
    Controversial(V0_19_0),
    Scaled(V0_19_0),
}
