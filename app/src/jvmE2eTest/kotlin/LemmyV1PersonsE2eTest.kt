import it.vercruysse.lemmyapi.datatypes.GetPersonDetails
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LemmyV1PersonsE2eTest : LemmyV1E2eTest() {
    @Test
    fun `anonymous person details returns the seeded administrator`() =
        runBlocking {
            val response = api.getPersonDetails(GetPersonDetails(username = ADMIN_USERNAME)).getOrThrow()
            val person = response.person_view.person

            assertEquals(ADMIN_USERNAME, person.name)
            assertTrue(person.local)
            assertTrue(person.published_at.isNotBlank())
        }
}
