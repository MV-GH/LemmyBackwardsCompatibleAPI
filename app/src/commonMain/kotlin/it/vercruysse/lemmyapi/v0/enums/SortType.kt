package it.vercruysse.lemmyapi.v0.enums

import kotlinx.serialization.Serializable
import it.vercruysse.lemmyapi.enums.CommunitySortType as UniCommunitySortType
import it.vercruysse.lemmyapi.enums.SortType as UniSortType

@Serializable
internal enum class SortType {
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
    TopHour,
    TopSixHour,
    TopTwelveHour,
    TopThreeMonths,
    TopSixMonths,
    TopNineMonths,
    Controversial,
    Scaled,
    ;

    fun toUni(): UniSortType =
        when (this) {
            Active -> UniSortType.Active
            Hot -> UniSortType.Hot
            New -> UniSortType.New
            Old -> UniSortType.Old
            TopDay -> UniSortType.TopDay
            TopWeek -> UniSortType.TopWeek
            TopMonth -> UniSortType.TopMonth
            TopYear -> UniSortType.TopYear
            TopAll -> UniSortType.TopAll
            MostComments -> UniSortType.MostComments
            NewComments -> UniSortType.NewComments
            TopHour -> UniSortType.TopHour
            TopSixHour -> UniSortType.TopSixHour
            TopTwelveHour -> UniSortType.TopTwelveHour
            TopThreeMonths -> UniSortType.TopThreeMonths
            TopSixMonths -> UniSortType.TopSixMonths
            TopNineMonths -> UniSortType.TopNineMonths
            Controversial -> UniSortType.Controversial
            Scaled -> UniSortType.Scaled
        }

    companion object {
        fun fromUniNullable(uni: UniSortType?): SortType? =
            when (uni) {
                null -> null
                UniSortType.Active -> Active
                UniSortType.Hot -> Hot
                UniSortType.New -> New
                UniSortType.Old -> Old
                UniSortType.TopDay -> TopDay
                UniSortType.TopWeek -> TopWeek
                UniSortType.TopMonth -> TopMonth
                UniSortType.TopYear -> TopYear
                UniSortType.TopAll -> TopAll
                UniSortType.MostComments -> MostComments
                UniSortType.NewComments -> NewComments
                UniSortType.TopHour -> TopHour
                UniSortType.TopSixHour -> TopSixHour
                UniSortType.TopTwelveHour -> TopTwelveHour
                UniSortType.TopThreeMonths -> TopThreeMonths
                UniSortType.TopSixMonths -> TopSixMonths
                UniSortType.TopNineMonths -> TopNineMonths
                UniSortType.Controversial -> Controversial
                UniSortType.Scaled -> Scaled
            }

        fun fromUni(uni: UniSortType): SortType = fromUniNullable(uni) ?: error("No v0 mapping for $uni")

        /** Pre 1.0 communities are sorted with the post sort, returns the one that orders communities the same way. */
        fun fromUniCommunitySort(uni: UniCommunitySortType?): SortType? =
            when (uni) {
                null -> null

                UniCommunitySortType.ActiveSixMonths -> TopSixMonths

                UniCommunitySortType.ActiveMonthly -> TopMonth

                UniCommunitySortType.ActiveWeekly -> TopWeek

                UniCommunitySortType.ActiveDaily -> TopDay

                UniCommunitySortType.Hot -> Hot

                UniCommunitySortType.New -> New

                UniCommunitySortType.Old -> Old

                UniCommunitySortType.Comments -> MostComments

                UniCommunitySortType.Subscribers -> TopAll

                UniCommunitySortType.NameAsc,
                UniCommunitySortType.NameDesc,
                UniCommunitySortType.Posts,
                UniCommunitySortType.SubscribersLocal,
                -> null
            }
    }
}

internal fun SortType?.toUni(): UniSortType? = this?.toUni()
