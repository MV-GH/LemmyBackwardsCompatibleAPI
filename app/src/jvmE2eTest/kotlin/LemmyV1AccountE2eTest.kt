import it.vercruysse.lemmyapi.datatypes.Login
import it.vercruysse.lemmyapi.datatypes.SaveUserSettings
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class LemmyV1AccountE2eTest : LemmyV1E2eTest() {
    @Test
    fun `registered user can fetch its own account`() =
        runBlocking {
            val registered = newUser()

            val me = registered.api.getMyUser().getOrThrow().local_user_view

            assertEquals(registered.username, me.person.name)
            assertFalse(me.local_user.admin)
        }

    @Test
    fun `admin account is flagged as admin`() =
        runBlocking {
            val me = adminApi.getMyUser().getOrThrow().local_user_view

            assertEquals(ADMIN_USERNAME, me.person.name)
            assertTrue(me.local_user.admin)
        }

    @Test
    fun `login with valid credentials returns a token`() =
        runBlocking {
            val response = anonApi.login(Login(user.username, USER_PASSWORD)).getOrThrow()

            assertNotNull(response.jwt)
        }

    @Test
    fun `login with a wrong password fails`() =
        runBlocking {
            val result = anonApi.login(Login(user.username, "definitely-not-the-password"))

            assertTrue(result.isFailure)
        }

    @Test
    fun `validate auth only succeeds when authenticated`() =
        runBlocking {
            assertTrue(user.api.validateAuth().isSuccess)
            assertTrue(anonApi.validateAuth().isFailure)
        }

    @Test
    fun `saved user settings are returned with the account`() =
        runBlocking {
            val settingsUser = newUser()

            settingsUser.api.saveUserSettings(
                SaveUserSettings(display_name = "E2E Display", bio = "E2E bio", show_nsfw = true),
            ).getOrThrow()

            val me = settingsUser.api.getMyUser().getOrThrow().local_user_view
            assertEquals("E2E Display", me.person.display_name)
            assertEquals("E2E bio", me.person.bio)
            assertTrue(me.local_user.show_nsfw)
        }

    @Test
    fun `logout invalidates the token`() =
        runBlocking {
            val loggedOut = newUser()
            assertTrue(loggedOut.api.validateAuth().isSuccess)

            loggedOut.api.logout().getOrThrow()

            assertTrue(loggedOut.api.validateAuth().isFailure)
        }

    @Test
    fun `new user has no unread notifications`() =
        runBlocking {
            assertEquals(0, newUser().api.getUnreadCounts().getOrThrow().notification_count)
        }
}
