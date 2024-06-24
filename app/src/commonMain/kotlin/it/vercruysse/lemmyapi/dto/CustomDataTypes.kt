@file:Suppress("unused")

package it.vercruysse.lemmyapi.dto

import io.github.z4kn4fein.semver.Version
import io.github.z4kn4fein.semver.toVersion
import io.github.z4kn4fein.semver.withoutSuffixes
import it.vercruysse.lemmyapi.MINIMUM_API_VERSION
import it.vercruysse.lemmyapi.V0_18_0
import it.vercruysse.lemmyapi.V0_19_0
import it.vercruysse.lemmyapi.V0_19_4
import it.vercruysse.lemmyapi.utils.isBetweenVersions
import kotlinx.serialization.Serializable

/*
 * Contains the datatypes that can't be autogenerated, bc Dukat doesn't support unions.
 * Thus, we have to manually create them and keep them up to date.
 * This is split in two groups, the first group is assumed to never change,
 * and the second group is assumed to change between versions. Therefore, the second group
 * implements a contract. Always use the getSupportedEntries<Enum> function to get the supported entries
 * for that version.
 *
 */

// GROUP 1

@Serializable
enum class SubscribedType {
    Subscribed,
    NotSubscribed,
    Pending,
}

@Serializable
enum class PostFeatureType {
    Local,
    Community,
}

// GROUP 2

@Serializable
enum class ListingType(
    override val minimumVersion: Version = MINIMUM_API_VERSION,
    override val maximumVersion: Version? = null,
) : VersionTracker {
    All,
    Local,
    Subscribed,
    ModeratorView(V0_19_0),
}

@Serializable
enum class RegistrationMode(
    override val minimumVersion: Version = MINIMUM_API_VERSION,
    override val maximumVersion: Version? = null,
) : VersionTracker {
    Closed,
    RequireApplication,
    Open,
}

@Serializable
enum class SearchType(
    override val minimumVersion: Version = MINIMUM_API_VERSION,
    override val maximumVersion: Version? = null,
) : VersionTracker {
    All,
    Comments,
    Posts,
    Communities,
    Users,
    Url,
}

@Serializable
enum class ModlogActionType(
    override val minimumVersion: Version = MINIMUM_API_VERSION,
    override val maximumVersion: Version? = null,
) : VersionTracker {
    All,
    ModRemovePost,
    ModLockPost,
    ModFeaturePost,
    ModRemoveComment,
    ModRemoveCommunity,
    ModBanFromCommunity,
    ModAddCommunity,
    ModTransferCommunity,
    ModAdd,
    ModBan,
    ModHideCommunity,
    AdminPurgePerson,
    AdminPurgeCommunity,
    AdminPurgePost,
    AdminPurgeComment,
}

@Serializable
enum class SortType(
    override val minimumVersion: Version = MINIMUM_API_VERSION,
    override val maximumVersion: Version? = null,
) : VersionTracker {
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

@Serializable
enum class CommentSortType(
    override val minimumVersion: Version = MINIMUM_API_VERSION,
    override val maximumVersion: Version? = null,
) : VersionTracker {
    Hot,
    Top,
    New,
    Old,
    Controversial(V0_19_0),
}

@Serializable
enum class PostListingMode(
    override val minimumVersion: Version = V0_19_0,
    override val maximumVersion: Version? = null,
) : VersionTracker {
    List,
    Card,
    SmallCard,
}

@Serializable
enum class CommunityVisibility(
    override val minimumVersion: Version = V0_19_4,
    override val maximumVersion: Version? = null,
) : VersionTracker {
    Public,
    LocalOnly,
}

/**
 * Tracks the version of the supported entries from this enum
 * Use this in conjunction with [getSupportedEntries]
 *
 * @property minimumVersion The version this entry was added
 * @property maximumVersion The version this entry was removed, if null, it is still supported
 */
@Serializable
sealed interface VersionTracker {
    val minimumVersion: Version
    val maximumVersion: Version?
}

/**
 * Returns the supported entries for the given version.
 * It is possible that this list is empty, such case means this type is not used at all in a newer version
 * Or doesn't exist in the older version.
 *
 * @param instanceVersion The version of the instance
 * @return A list of supported entries
 */
inline fun <reified T> getSupportedEntries(instanceVersion: String): List<T> where T : Enum<T>, T : VersionTracker {
    return getSupportedEntries(instanceVersion.toVersion(strict = false))
}

/**
 * Returns the supported entries for the given version.
 * It is possible that this list is empty, such case means this type is not used at all in a newer version
 * Or doesn't exist in the older version.
 *
 * @param instanceVersion The version of the instance
 * @return A list of supported entries
 */
inline fun <reified T> getSupportedEntries(instanceVersion: Version): List<T> where T : Enum<T>, T : VersionTracker {
    val ignorePreReleaseVersion = instanceVersion.withoutSuffixes()
    return enumValues<T>().filter {
        val max = it.maximumVersion
        if (max == null) {
            ignorePreReleaseVersion >= it.minimumVersion
        } else {
            isBetweenVersions(ignorePreReleaseVersion, it.minimumVersion, max)
        }
    }
}

typealias ImportUserSettings = String
typealias ExportUserSettingsResponse = String
