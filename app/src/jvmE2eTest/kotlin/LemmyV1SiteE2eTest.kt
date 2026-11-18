import it.vercruysse.lemmyapi.datatypes.GetFederatedInstances
import it.vercruysse.lemmyapi.enums.GetFederatedInstancesKind
import it.vercruysse.lemmyapi.enums.RegistrationMode
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
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

            assertTrue(local.local_posts >= seededPostIds.size)
            assertTrue(local.local_comments >= seededCommentIds.size)
            assertTrue(local.local_communities >= 1)
        }

    @Test
    fun `admin can upload and delete the site icon and banner`() =
        runBlocking<Unit> {
            val icon = adminApi.uploadSiteIcon(PNG).getOrThrow()
            val banner = adminApi.uploadSiteBanner(PNG).getOrThrow()
            // getSite is cached for a short while
            eventually {
                val uploaded = anonApi.getSite().getOrThrow().site_view.site
                assertEquals(icon.image_url, uploaded.icon)
                assertEquals(banner.image_url, uploaded.banner)
            }

            adminApi.deleteSiteIcon().getOrThrow()
            adminApi.deleteSiteBanner().getOrThrow()
            eventually {
                val deleted = anonApi.getSite().getOrThrow().site_view.site
                assertNull(deleted.icon)
                assertNull(deleted.banner)
            }
        }

    @Test
    fun `federated instances can be listed`() =
        runBlocking<Unit> {
            assertTrue(anonApi.getFederatedInstances(GetFederatedInstances(kind = GetFederatedInstancesKind.All)).isSuccess)
        }
}
