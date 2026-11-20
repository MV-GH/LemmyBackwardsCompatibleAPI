import it.vercruysse.lemmyapi.datatypes.ChangePassword
import it.vercruysse.lemmyapi.datatypes.DeleteAccount
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
        runBlocking<Unit> {
            // The user was registered during setup, a login in the same second would produce the same token
            // and fail on the unique login_token key. stay_logged_in gives this token another expiry.
            val response = anonApi.login(Login(user.username, USER_PASSWORD, stay_logged_in = true)).getOrThrow()

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

    @Test
    fun `user can change its password`() =
        runBlocking<Unit> {
            val changer = newUser()

            // Lemmy's JWT only differs by user, issue second and expiry, so a login in the same second as the
            // password change would produce the same token and fail on the unique login_token key.
            // stay_logged_in gives this token another expiry, so the login after it gets a different token.
            val changed =
                changer.api.changePassword(
                    ChangePassword("e2e-new-password", "e2e-new-password", USER_PASSWORD, stay_logged_in = true),
                ).getOrThrow()
            assertNotNull(changed.jwt)
            assertTrue(anonApi.login(Login(changer.username, USER_PASSWORD)).isFailure)
            assertTrue(anonApi.login(Login(changer.username, "e2e-new-password")).isSuccess)
        }

    @Test
    fun `user can delete its account`() =
        runBlocking<Unit> {
            val deleter = newUser()

            deleter.api.deleteAccount(DeleteAccount(USER_PASSWORD, delete_content = true)).getOrThrow()

            // Lemmy 1.0 still accepts a login of a deleted account, but its existing tokens are revoked
            assertTrue(deleter.api.getMyUser().isFailure)
        }

    @Test
    fun `logins of the user are listed`() =
        runBlocking<Unit> {
            assertTrue(newUser().api.listLogins().getOrThrow().logins.isNotEmpty())
        }

    @Test
    fun `exported user settings can be imported by another user`() =
        runBlocking<Unit> {
            val exporter = newUser()
            val importer = newUser()
            exporter.api.saveUserSettings(SaveUserSettings(bio = "e2e exported bio")).getOrThrow()

            val exported = exporter.api.exportUserSettings().getOrThrow()
            importer.api.importUserSettings(exported).getOrThrow()

            eventually { assertEquals("e2e exported bio", importer.api.getMyUser().getOrThrow().local_user_view.person.bio) }
        }

    @Test
    fun `donation dialog can be marked as shown`() =
        runBlocking<Unit> {
            newUser().api.markDonationDialogShown().getOrThrow()
        }
}
