import it.vercruysse.lemmyapi.datatypes.GetPosts
import it.vercruysse.lemmyapi.datatypes.SaveUserSettings
import it.vercruysse.lemmyapi.enums.SortType
import it.vercruysse.lemmyapi.v1.x0.x0.Transformer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.long
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import it.vercruysse.lemmyapi.v1.enums.SortType as V1SortType
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.GetPosts as V1GetPosts
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.SaveUserSettings as V1SaveUserSettings

class V1SortTypeTest {
    private val transformer = Transformer()
    private val json = Json { explicitNulls = false }

    @Test
    fun `top sorts are sent as top with a time range on 1_0`() {
        val expected =
            mapOf(
                SortType.TopHour to 3_600L,
                SortType.TopSixHour to 21_600L,
                SortType.TopTwelveHour to 43_200L,
                SortType.TopDay to 86_400L,
                SortType.TopWeek to 604_800L,
                SortType.TopMonth to 2_592_000L,
                SortType.TopThreeMonths to 7_776_000L,
                SortType.TopSixMonths to 15_552_000L,
                SortType.TopNineMonths to 23_328_000L,
                SortType.TopYear to 31_536_000L,
                SortType.TopAll to 0L,
            )
        expected.forEach { (sort, seconds) ->
            val form = transformer.fromUni(GetPosts(sort = sort))
            assertEquals(V1SortType.Top, form.sort, "$sort")
            assertEquals(seconds, form.time_range_seconds, "$sort")
        }
    }

    @Test
    fun `saving only a top sort also sends its time range`() {
        val form = transformer.fromUni(SaveUserSettings(default_post_sort_type = SortType.TopWeek))
        val body = json.encodeToJsonElement(V1SaveUserSettings.serializer(), form).jsonObject

        assertEquals("top", body["default_post_sort_type"]!!.jsonPrimitive.content)
        assertEquals(604_800L, body["default_post_time_range_seconds"]!!.jsonPrimitive.long)
    }

    @Test
    fun `an explicit time range wins over the top variant`() {
        val form = transformer.fromUni(GetPosts(sort = SortType.TopDay, time_range_seconds = 1_234L))
        assertEquals(V1SortType.Top, form.sort)
        assertEquals(1_234L, form.time_range_seconds)
    }

    @Test
    fun `non top sorts are sent unchanged`() {
        val form = transformer.fromUni(GetPosts(sort = SortType.Hot))
        val body = json.encodeToJsonElement(V1GetPosts.serializer(), form).jsonObject

        assertEquals("hot", body["sort"]!!.jsonPrimitive.content)
        assertNull(form.time_range_seconds)
        assertNull(transformer.fromUni(SaveUserSettings(show_nsfw = true)).default_post_sort_type)
    }

    @Test
    fun `top with a time range is read back as the closest top variant`() {
        assertEquals(SortType.TopWeek, V1SortType.Top.toUni(604_800L))
        assertEquals(SortType.TopDay, V1SortType.Top.toUni(86_400L))
        assertEquals(SortType.TopMonth, V1SortType.Top.toUni(31L * 86_400L))
        assertEquals(SortType.TopHour, V1SortType.Top.toUni(60L))
        assertEquals(SortType.TopAll, V1SortType.Top.toUni(null))
        assertEquals(SortType.TopAll, V1SortType.Top.toUni(0L))
        assertEquals(SortType.Hot, V1SortType.Hot.toUni(604_800L))
        assertEquals(V1SortType.Top, Json.decodeFromString(V1SortType.serializer(), "\"top\""))
    }

    @Test
    fun `every unified sort round trips through 1_0`() {
        SortType.entries.forEach { sort ->
            val (v1, seconds) = V1SortType.fromUni(sort, null)
            assertEquals(sort, v1!!.toUni(seconds), "$sort")
        }
    }
}
