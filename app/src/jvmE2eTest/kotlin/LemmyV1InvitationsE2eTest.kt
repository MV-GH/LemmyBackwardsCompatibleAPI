import it.vercruysse.lemmyapi.LemmyApiBaseController
import it.vercruysse.lemmyapi.datatypes.CreateInvitation
import it.vercruysse.lemmyapi.datatypes.EditSite
import it.vercruysse.lemmyapi.datatypes.ListInvitations
import it.vercruysse.lemmyapi.datatypes.LocalUserInvite
import it.vercruysse.lemmyapi.datatypes.Register
import it.vercruysse.lemmyapi.datatypes.RevokeInvitation
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

class LemmyV1InvitationsE2eTest : LemmyV1E2eTest() {
    private suspend fun LemmyApiBaseController.invitations(): List<LocalUserInvite> =
        fetchPages { listRegistrationInvitations(ListInvitations(page_cursor = it)) }.flatten()

    private suspend fun LemmyApiBaseController.newInvitation(maxUses: Long? = null): LocalUserInvite =
        createRegistrationInvitation(CreateInvitation(max_uses = maxUses)).getOrThrow().invite

    // Lemmy caches the local site for a second
    private suspend fun LemmyApiBaseController.setRegistrationMode(mode: RegistrationMode) {
        editSite(EditSite(registration_mode = mode)).getOrThrow()
        delay(2.seconds)
    }

    @Test
    fun `created invitation is listed`() =
        runBlocking {
            val invite = adminApi.newInvitation(maxUses = 3)

            val listed = adminApi.invitations().single { it.token == invite.token }

            assertEquals(3L, listed.max_uses)
            assertEquals(0L, listed.uses_count)
        }

    @Test
    fun `revoked invitation is no longer listed`() =
        runBlocking {
            val invite = adminApi.newInvitation()

            adminApi.revokeRegistrationInvitation(RevokeInvitation(invite.token)).getOrThrow()

            assertFalse(adminApi.invitations().any { it.token == invite.token })
        }

    @Test
    fun `invitations are private to their creator`() =
        runBlocking {
            val invite = adminApi.newInvitation()
            val other = newUser()

            assertFalse(other.api.invitations().any { it.token == invite.token })
            assertTrue(other.api.revokeRegistrationInvitation(RevokeInvitation(invite.token)).isFailure)
            assertTrue(adminApi.invitations().any { it.token == invite.token })
        }

    @Test
    fun `listing invitations requires authentication`() =
        runBlocking {
            assertTrue(anonApi.listRegistrationInvitations(ListInvitations()).isFailure)
        }

    @Test
    fun `invitation is required and used up when registering in require invitation mode`() =
        runBlocking {
            val invite = adminApi.newInvitation(maxUses = 2)
            adminApi.setRegistrationMode(RegistrationMode.RequireInvitation)
            try {
                val withoutToken = unique("e2ei")
                assertTrue(anonApi.register(Register(withoutToken, USER_PASSWORD, USER_PASSWORD)).isFailure)

                val first = unique("e2ei")
                assertNotNull(anonApi.register(Register(first, USER_PASSWORD, USER_PASSWORD, token = invite.token)).getOrThrow().jwt)
                assertEquals(1L, adminApi.invitations().single { it.token == invite.token }.uses_count)

                val second = unique("e2ei")
                assertNotNull(anonApi.register(Register(second, USER_PASSWORD, USER_PASSWORD, token = invite.token)).getOrThrow().jwt)
                assertNull(adminApi.invitations().firstOrNull { it.token == invite.token })
            } finally {
                adminApi.setRegistrationMode(RegistrationMode.Open)
            }
        }
}
