import it.vercruysse.lemmyapi.datatypes.EditSite
import it.vercruysse.lemmyapi.datatypes.GetPosts
import it.vercruysse.lemmyapi.datatypes.SaveUserSettings
import it.vercruysse.lemmyapi.enums.SortType
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.time.Duration.Companion.seconds

/** 1.0 only knows `top` plus `time_range_seconds`; the unified `Top*` sorts must be translated. */
class LemmyV1SortE2eTest : LemmyV1E2eTest() {
    private val topSorts = SortType.entries.filter { it.name.startsWith("Top") }

    @Test
    fun `saving a top sort as the only changed setting stores top with its time range`() =
        runBlocking {
            val settingsUser = newUser()

            settingsUser.api.saveUserSettings(SaveUserSettings(default_post_sort_type = SortType.TopWeek)).getOrThrow()
            val week = settingsUser.api.getMyUser().getOrThrow().local_user_view.local_user
            assertEquals(SortType.TopWeek, week.default_post_sort_type)
            assertEquals(604_800L, week.default_post_time_range_seconds)

            settingsUser.api.saveUserSettings(SaveUserSettings(default_post_sort_type = SortType.TopAll)).getOrThrow()
            val all = settingsUser.api.getMyUser().getOrThrow().local_user_view.local_user
            assertEquals(SortType.TopAll, all.default_post_sort_type)
            assertNull(all.default_post_time_range_seconds)

            settingsUser.api.saveUserSettings(SaveUserSettings(default_post_sort_type = SortType.Hot)).getOrThrow()
            assertEquals(SortType.Hot, settingsUser.api.getMyUser().getOrThrow().local_user_view.local_user.default_post_sort_type)
        }

    @Test
    fun `every top sort can be saved and is read back`() =
        runBlocking {
            val settingsUser = newUser()

            topSorts.forEach { sort ->
                settingsUser.api.saveUserSettings(SaveUserSettings(default_post_sort_type = sort)).getOrThrow()
                assertEquals(sort, settingsUser.api.getMyUser().getOrThrow().local_user_view.local_user.default_post_sort_type)
            }
        }

    @Test
    fun `feed can be sorted by every top sort`() =
        runBlocking {
            val fresh = user.api.newPost(title = unique("Top sort post "))

            topSorts.forEach { sort ->
                val posts = anonApi.getPosts(GetPosts(community_name = SEED_COMMUNITY_NAME, sort = sort)).getOrThrow()
                assertTrue(posts.items.any { it.post.id == fresh.post.id }, "$sort should include a post made just now")
            }
        }

    @Test
    fun `explicit feed sorts still work when a top week default is stored`() =
        runBlocking {
            val reader = newUser()
            reader.api.saveUserSettings(SaveUserSettings(default_post_sort_type = SortType.TopWeek)).getOrThrow()

            // The feed sort is sent explicitly, it must not be replaced by the stored default
            val hot = reader.api.getPosts(GetPosts(community_name = SEED_COMMUNITY_NAME, sort = SortType.Hot)).getOrThrow()
            assertTrue(hot.items.isNotEmpty())
            val topAll = reader.api.getPosts(GetPosts(community_name = SEED_COMMUNITY_NAME, sort = SortType.TopAll)).getOrThrow()
            assertTrue(topAll.items.isNotEmpty())
        }

    @Test
    fun `site default top sort is saved and read back`() =
        runBlocking {
            val original = adminApi.getSite().getOrThrow().site_view.local_site

            try {
                adminApi.editSite(EditSite(default_post_sort_type = SortType.TopMonth)).getOrThrow()
                // Lemmy caches the local site for a second
                delay(2.seconds)
                val local = anonApi.getSite().getOrThrow().site_view.local_site
                assertEquals(SortType.TopMonth, local.default_post_sort_type)
                assertEquals(2_592_000L, local.default_post_time_range_seconds)
            } finally {
                adminApi.editSite(
                    EditSite(
                        default_post_sort_type = original.default_post_sort_type,
                        default_post_time_range_seconds = original.default_post_time_range_seconds ?: 0L,
                    ),
                ).getOrThrow()
                delay(2.seconds)
            }
        }
}
