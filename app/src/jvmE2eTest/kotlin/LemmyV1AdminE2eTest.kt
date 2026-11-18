import it.vercruysse.lemmyapi.LemmyApiBaseController
import it.vercruysse.lemmyapi.datatypes.AddAdmin
import it.vercruysse.lemmyapi.datatypes.AdminAllowInstanceParams
import it.vercruysse.lemmyapi.datatypes.AdminBlockInstanceParams
import it.vercruysse.lemmyapi.datatypes.AdminListUsers
import it.vercruysse.lemmyapi.datatypes.ApproveRegistrationApplication
import it.vercruysse.lemmyapi.datatypes.BanPerson
import it.vercruysse.lemmyapi.datatypes.CreateCustomEmoji
import it.vercruysse.lemmyapi.datatypes.CreateTagline
import it.vercruysse.lemmyapi.datatypes.DeleteCustomEmoji
import it.vercruysse.lemmyapi.datatypes.DeleteTagline
import it.vercruysse.lemmyapi.datatypes.EditCustomEmoji
import it.vercruysse.lemmyapi.datatypes.EditSite
import it.vercruysse.lemmyapi.datatypes.EditTagline
import it.vercruysse.lemmyapi.datatypes.GetComment
import it.vercruysse.lemmyapi.datatypes.GetCommunity
import it.vercruysse.lemmyapi.datatypes.GetModlog
import it.vercruysse.lemmyapi.datatypes.GetPersonDetails
import it.vercruysse.lemmyapi.datatypes.GetPost
import it.vercruysse.lemmyapi.datatypes.GetRegistrationApplication
import it.vercruysse.lemmyapi.datatypes.ListCustomEmojis
import it.vercruysse.lemmyapi.datatypes.ListRegistrationApplications
import it.vercruysse.lemmyapi.datatypes.ListTaglines
import it.vercruysse.lemmyapi.datatypes.Login
import it.vercruysse.lemmyapi.datatypes.PurgeComment
import it.vercruysse.lemmyapi.datatypes.PurgeCommunity
import it.vercruysse.lemmyapi.datatypes.PurgePerson
import it.vercruysse.lemmyapi.datatypes.PurgePost
import it.vercruysse.lemmyapi.datatypes.Register
import it.vercruysse.lemmyapi.datatypes.Tagline
import it.vercruysse.lemmyapi.enums.ModlogKind
import it.vercruysse.lemmyapi.enums.RegistrationMode
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.time.Duration.Companion.seconds

class LemmyV1AdminE2eTest : LemmyV1E2eTest() {
    private suspend fun LemmyApiBaseController.taglines(): List<Tagline> =
        fetchPages { listTaglines(ListTaglines(page_cursor = it)) }.flatten()

    // Lemmy caches the local site for a second
    private suspend fun LemmyApiBaseController.editSiteAndWait(form: EditSite) {
        editSite(form).getOrThrow()
        delay(2.seconds)
    }

    @Test
    fun `custom emoji can be created, edited, listed and deleted`() =
        runBlocking {
            val shortcode = unique("e2eemoji")
            val created = adminApi.createCustomEmoji(
                CreateCustomEmoji("e2e", shortcode, "https://example.com/$shortcode.png", "e2e alt", listOf("e2e", "test")),
            ).getOrThrow().custom_emoji
            assertEquals(shortcode, created.custom_emoji.shortcode)
            assertEquals(setOf("e2e", "test"), created.keywords.map { it.keyword }.toSet())

            val edited = adminApi.editCustomEmoji(EditCustomEmoji(created.custom_emoji.id, alt_text = "edited alt"))
                .getOrThrow().custom_emoji
            assertEquals("edited alt", edited.custom_emoji.alt_text)
            assertEquals("e2e", edited.custom_emoji.category)

            assertTrue(anonApi.listCustomEmojis(ListCustomEmojis()).getOrThrow().custom_emojis.any { it.custom_emoji.shortcode == shortcode })

            adminApi.deleteCustomEmoji(DeleteCustomEmoji(created.custom_emoji.id)).getOrThrow()
            assertFalse(adminApi.listCustomEmojis(ListCustomEmojis()).getOrThrow().custom_emojis.any { it.custom_emoji.id == created.custom_emoji.id })
        }

    @Test
    fun `custom emoji management needs an admin`() =
        runBlocking {
            assertTrue(user.api.createCustomEmoji(CreateCustomEmoji("e2e", unique("e2eemoji"), "https://example.com/x.png", "alt", emptyList())).isFailure)
        }

    @Test
    fun `tagline can be created, edited, listed and deleted`() =
        runBlocking {
            val created = adminApi.createTagline(CreateTagline(unique("E2E tagline"))).getOrThrow().tagline
            assertTrue(adminApi.taglines().any { it.id == created.id })

            val edited = adminApi.editTagline(EditTagline(created.id, "E2E edited tagline")).getOrThrow().tagline
            assertEquals("E2E edited tagline", edited.content)
            assertNotNull(edited.updated_at)

            adminApi.deleteTagline(DeleteTagline(created.id)).getOrThrow()
            assertFalse(adminApi.taglines().any { it.id == created.id })
        }

    @Test
    fun `registration application can be listed, read and approved`() =
        runBlocking<Unit> {
            val username = unique("e2ea")
            adminApi.editSiteAndWait(EditSite(registration_mode = RegistrationMode.RequireApplication, application_question = "Why?"))
            val registration = try {
                anonApi.register(Register(username, USER_PASSWORD, USER_PASSWORD, answer = "e2e answer")).getOrThrow()
            } finally {
                adminApi.editSiteAndWait(EditSite(registration_mode = RegistrationMode.Open))
            }
            assertTrue(registration.registration_created)
            assertNull(registration.jwt)

            val application = fetchPages { adminApi.listRegistrationApplications(ListRegistrationApplications(unread_only = true, page_cursor = it)) }
                .flatten().single { it.creator.name == username }
            assertEquals("e2e answer", application.registration_application.answer)

            val read = adminApi.getRegistrationApplication(GetRegistrationApplication(application.creator.id))
                .getOrThrow().registration_application
            assertEquals(application.registration_application.id, read.registration_application.id)

            val approved = adminApi.approveRegistrationApplication(ApproveRegistrationApplication(application.registration_application.id, true))
                .getOrThrow().registration_application
            assertNotNull(approved.admin)
            assertNotNull(anonApi.login(Login(username, USER_PASSWORD)).getOrThrow().jwt)
        }

    @Test
    fun `admin can be added and removed`() =
        runBlocking {
            val candidate = newUser()

            val admins = adminApi.addAdmin(AddAdmin(candidate.personId, true)).getOrThrow().admins
            assertTrue(admins.any { it.person.id == candidate.personId })
            assertTrue(candidate.api.getMyUser().getOrThrow().local_user_view.local_user.admin)

            val remaining = adminApi.addAdmin(AddAdmin(candidate.personId, false)).getOrThrow().admins
            assertFalse(remaining.any { it.person.id == candidate.personId })
            assertFalse(candidate.api.getMyUser().getOrThrow().local_user_view.local_user.admin)
        }

    @Test
    fun `admin user list contains local users and filters banned ones`() =
        runBlocking {
            val banned = newUser()
            adminApi.banPerson(BanPerson(banned.personId, true, reason = "e2e admin list")).getOrThrow()

            val all = fetchPages { adminApi.adminListUsers(AdminListUsers(page_cursor = it)) }.flatten()
            assertTrue(all.any { it.person.id == user.personId })

            val bannedOnly = fetchPages { adminApi.adminListUsers(AdminListUsers(banned_only = true, page_cursor = it)) }.flatten()
            assertTrue(bannedOnly.any { it.person.id == banned.personId })
            assertFalse(bannedOnly.any { it.person.id == user.personId })

            assertTrue(user.api.adminListUsers(AdminListUsers()).isFailure)
        }

    @Test
    fun `purged content is gone and logged`() =
        runBlocking {
            val author = newUser()
            val community = adminApi.newCommunity()
            val post = author.api.newPost(inCommunity = community).post
            val comment = author.api.newComment(onPost = post.id).comment
            val otherPost = author.api.newPost().post

            adminApi.purgeComment(PurgeComment(comment.id, "e2e purge comment")).getOrThrow()
            assertTrue(adminApi.getComment(GetComment(comment.id)).isFailure)
            assertLogged(ModlogKind.AdminPurgeComment, "e2e purge comment")

            adminApi.purgePost(PurgePost(otherPost.id, "e2e purge post")).getOrThrow()
            assertTrue(adminApi.getPost(GetPost(id = otherPost.id)).isFailure)
            assertLogged(ModlogKind.AdminPurgePost, "e2e purge post")

            adminApi.purgeCommunity(PurgeCommunity(community, "e2e purge community")).getOrThrow()
            assertTrue(adminApi.getCommunity(GetCommunity(id = community)).isFailure)
            assertLogged(ModlogKind.AdminPurgeCommunity, "e2e purge community")

            adminApi.purgePerson(PurgePerson(author.personId, "e2e purge person")).getOrThrow()
            // Lemmy keeps the person record but bans it, so it can't log in or be refetched from its home instance
            assertTrue(adminApi.getPersonDetails(GetPersonDetails(person_id = author.personId)).getOrThrow().person_view.banned)
            assertLogged(ModlogKind.AdminPurgePerson, "e2e purge person")
        }

    private suspend fun assertLogged(kind: ModlogKind, reason: String) {
        val log = fetchPages { adminApi.getModlog(GetModlog(page_cursor = it)) }.flatten()
        assertTrue(log.any { it.modlog.kind == kind && it.modlog.reason == reason }, "$kind not in ${log.map { it.modlog.kind }}")
    }

    @Test
    fun `instance can be blocked and allowed`() =
        runBlocking {
            val domain = "${unique("blocked")}.example.com"

            adminApi.adminBlockInstance(AdminBlockInstanceParams(domain, true, "e2e block")).getOrThrow()
            adminApi.adminBlockInstance(AdminBlockInstanceParams(domain, false, "e2e unblock")).getOrThrow()
            adminApi.adminAllowInstance(AdminAllowInstanceParams(domain, true, "e2e allow")).getOrThrow()
            adminApi.adminAllowInstance(AdminAllowInstanceParams(domain, false, "e2e disallow")).getOrThrow()

            val log = fetchPages { adminApi.getModlog(GetModlog(page_cursor = it)) }.flatten()
            assertTrue(log.any { it.modlog.kind == ModlogKind.AdminBlockInstance && it.target_instance?.domain == domain })
            assertTrue(log.any { it.modlog.kind == ModlogKind.AdminAllowInstance && it.target_instance?.domain == domain })
            assertTrue(user.api.adminBlockInstance(AdminBlockInstanceParams(domain, true, "not admin")).isFailure)
        }
}
