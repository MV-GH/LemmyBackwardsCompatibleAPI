import it.vercruysse.lemmyapi.enums.RegistrationMode
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LemmyV1SiteE2eTest : LemmyV1E2eTest() {
    @Test
    fun `anonymous site info describes the instance`() =
        runBlocking {
            val site = anonApi.getSite().getOrThrow()

            assertEquals("lemmy-e2e", site.site_view.site.name)
            assertEquals(RegistrationMode.Open, site.site_view.local_site.registration_mode)
            assertTrue(site.version.startsWith("1.0"), "Unexpected version ${site.version}")
            assertTrue(site.admins.any { it.person.name == ADMIN_USERNAME })
            assertTrue(site.all_languages.isNotEmpty())
        }

    @Test
    fun `site counters include the seeded content`() =
        runBlocking {
            val local = anonApi.getSite().getOrThrow().site_view.local_site

            assertTrue(local.posts >= seededPostIds.size)
            assertTrue(local.comments >= seededCommentIds.size)
            assertTrue(local.communities >= 1)
        }
}
