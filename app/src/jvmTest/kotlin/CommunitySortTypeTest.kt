import it.vercruysse.lemmyapi.datatypes.ListCommunities
import it.vercruysse.lemmyapi.enums.CommunitySortType
import it.vercruysse.lemmyapi.v1.x0.x0.Transformer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import it.vercruysse.lemmyapi.v0.enums.SortType as V0SortType
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ListCommunities as V1ListCommunities

class CommunitySortTypeTest {
    @Test
    fun `list communities sends the community sort unchanged on 1_0`() {
        val transformer = Transformer()
        val expected =
            mapOf(
                CommunitySortType.ActiveSixMonths to "active_six_months",
                CommunitySortType.ActiveMonthly to "active_monthly",
                CommunitySortType.ActiveWeekly to "active_weekly",
                CommunitySortType.ActiveDaily to "active_daily",
                CommunitySortType.Hot to "hot",
                CommunitySortType.New to "new",
                CommunitySortType.Old to "old",
                CommunitySortType.NameAsc to "name_asc",
                CommunitySortType.NameDesc to "name_desc",
                CommunitySortType.Comments to "comments",
                CommunitySortType.Posts to "posts",
                CommunitySortType.Subscribers to "subscribers",
                CommunitySortType.SubscribersLocal to "subscribers_local",
            )
        assertEquals(CommunitySortType.entries.toSet(), expected.keys)
        expected.forEach { (sort, wire) ->
            val body = Json.encodeToJsonElement(V1ListCommunities.serializer(), transformer.fromUni(ListCommunities(sort = sort))).jsonObject
            assertEquals(wire, body["sort"]!!.jsonPrimitive.content)
        }
    }

    @Test
    fun `list communities sends the matching post sort pre 1_0`() {
        val expected =
            mapOf(
                CommunitySortType.ActiveSixMonths to V0SortType.TopSixMonths,
                CommunitySortType.ActiveMonthly to V0SortType.TopMonth,
                CommunitySortType.ActiveWeekly to V0SortType.TopWeek,
                CommunitySortType.ActiveDaily to V0SortType.TopDay,
                CommunitySortType.Hot to V0SortType.Hot,
                CommunitySortType.New to V0SortType.New,
                CommunitySortType.Old to V0SortType.Old,
                CommunitySortType.Comments to V0SortType.MostComments,
                CommunitySortType.Subscribers to V0SortType.TopAll,
            )
        expected.forEach { (sort, v0) ->
            val form = ListCommunities(sort = sort)
            assertEquals(v0, it.vercruysse.lemmyapi.v0.x18.x5.Transformer("token").fromUni(form).sort, "$sort")
            assertEquals(v0, it.vercruysse.lemmyapi.v0.x19.x0.Transformer().fromUni(form).sort, "$sort")
            assertEquals(v0, it.vercruysse.lemmyapi.v0.x19.x11.Transformer().fromUni(form).sort, "$sort")
        }
    }

    @Test
    fun `community sorts added in 1_0 fall back to the server default pre 1_0`() {
        CommunitySortType.entries.filter { it.minimumVersion.major >= 1 }.forEach { sort ->
            assertNull(it.vercruysse.lemmyapi.v0.x19.x11.Transformer().fromUni(ListCommunities(sort = sort)).sort, "$sort")
        }
    }
}
