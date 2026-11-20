package it.vercruysse.lemmyapi.v1.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.math.abs
import kotlin.math.ln
import it.vercruysse.lemmyapi.enums.SortType as UniSortType

/**
 * Post sort type of Lemmy 1.0. The unified `Top*` variants are collapsed into [Top],
 * the time range is sent separately as `time_range_seconds`.
 */
@Serializable
internal enum class SortType {
    @SerialName("active")
    Active,

    @SerialName("hot")
    Hot,

    @SerialName("new")
    New,

    @SerialName("old")
    Old,

    @SerialName("top")
    Top,

    @SerialName("most_comments")
    MostComments,

    @SerialName("new_comments")
    NewComments,

    @SerialName("controversial")
    Controversial,

    @SerialName("scaled")
    Scaled,
    ;

    /** Maps back to the unified sort, picking the `Top*` variant closest to [timeRangeSeconds]. */
    fun toUni(timeRangeSeconds: Long?): UniSortType =
        when (this) {
            Active -> UniSortType.Active
            Hot -> UniSortType.Hot
            New -> UniSortType.New
            Old -> UniSortType.Old
            Top -> closestTop(timeRangeSeconds)
            MostComments -> UniSortType.MostComments
            NewComments -> UniSortType.NewComments
            Controversial -> UniSortType.Controversial
            Scaled -> UniSortType.Scaled
        }

    companion object {
        private const val HOUR = 3600L
        private const val DAY = 24 * HOUR

        /** Time range in seconds for every unified `Top*` sort. `TopAll` has no range. */
        val TOP_TIME_RANGES: Map<UniSortType, Long?> =
            linkedMapOf(
                UniSortType.TopHour to HOUR,
                UniSortType.TopSixHour to 6 * HOUR,
                UniSortType.TopTwelveHour to 12 * HOUR,
                UniSortType.TopDay to DAY,
                UniSortType.TopWeek to 7 * DAY,
                UniSortType.TopMonth to 30 * DAY,
                UniSortType.TopThreeMonths to 90 * DAY,
                UniSortType.TopSixMonths to 180 * DAY,
                UniSortType.TopNineMonths to 270 * DAY,
                UniSortType.TopYear to 365 * DAY,
                UniSortType.TopAll to null,
            )

        /**
         * 1.0 erases a stored time range (user/site default) when it receives 0,
         * and for queries 0 overrides the user/site default range.
         */
        const val NO_TIME_RANGE = 0L

        fun closestTop(timeRangeSeconds: Long?): UniSortType {
            if (timeRangeSeconds == null || timeRangeSeconds <= 0) return UniSortType.TopAll
            return TOP_TIME_RANGES.entries
                .filter { it.value != null }
                .minBy { abs(ln(timeRangeSeconds.toDouble() / it.value!!)) }
                .key
        }

        fun fromUni(uni: UniSortType): SortType =
            when (uni) {
                UniSortType.Active -> Active

                UniSortType.Hot -> Hot

                UniSortType.New -> New

                UniSortType.Old -> Old

                UniSortType.MostComments -> MostComments

                UniSortType.NewComments -> NewComments

                UniSortType.Controversial -> Controversial

                UniSortType.Scaled -> Scaled

                UniSortType.TopDay,
                UniSortType.TopWeek,
                UniSortType.TopMonth,
                UniSortType.TopYear,
                UniSortType.TopAll,
                UniSortType.TopHour,
                UniSortType.TopSixHour,
                UniSortType.TopTwelveHour,
                UniSortType.TopThreeMonths,
                UniSortType.TopSixMonths,
                UniSortType.TopNineMonths,
                -> Top
            }

        /**
         * Converts a unified sort plus an optional explicit time range into the 1.0 sort and time range.
         *
         * - A `Top*` sort sends `top` with its range; an explicitly given [timeRangeSeconds] wins.
         *   `TopAll` sends [NO_TIME_RANGE] so a stored or default range is cleared/overridden.
         * - Any other sort, or no sort, passes [timeRangeSeconds] through unchanged.
         */
        fun fromUni(uni: UniSortType?, timeRangeSeconds: Long?): Pair<SortType?, Long?> {
            if (uni == null) return null to timeRangeSeconds
            val v1 = fromUni(uni)
            if (v1 != Top) return v1 to timeRangeSeconds
            return v1 to (timeRangeSeconds ?: TOP_TIME_RANGES[uni] ?: NO_TIME_RANGE)
        }
    }
}
