import it.vercruysse.lemmyapi.IGNORE_UNKNOWN_KEYS_JSON
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue
import it.vercruysse.lemmyapi.datatypes.PersonView as UniPersonView
import it.vercruysse.lemmyapi.datatypes.ResolveObjectView as UniResolveObjectView
import it.vercruysse.lemmyapi.datatypes.SearchResponse as UniSearchResponse
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.NotificationData as V1NotificationData
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.PersonView as V1PersonView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.ResolveObjectView as V1ResolveObjectView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.SearchResponse as V1SearchResponse

class SealedInterfaceSerializationTest {
    private val searchResponseJson =
        """
        {
          "resolve": {
            "type_": "person",
            "person": {
              "id": 1, "name": "name", "published_at": "2025-01-01T00:00:00Z", "ap_id": "https://example.com/u/name",
              "local": true, "last_refreshed_at": "2025-01-01T00:00:00Z", "deleted": false, "bot_account": false,
              "instance_id": 1, "post_count": 0, "comment_count": 0
            },
            "is_admin": false,
            "banned": false
          },
          "comments": [], "posts": [], "communities": [], "persons": [], "multi_communities": []
        }
        """.trimIndent()

    @Test
    fun `generated v1 sealed interface is resolved by its class discriminator`() {
        val response = IGNORE_UNKNOWN_KEYS_JSON.decodeFromString<V1SearchResponse>(searchResponseJson)

        val resolved = assertIs<V1PersonView>(response.resolve)
        assertEquals("name", resolved.person.name)
    }

    @Test
    fun `generated v1 sealed interface is encoded with its class discriminator`() {
        val response = IGNORE_UNKNOWN_KEYS_JSON.decodeFromString<V1SearchResponse>(searchResponseJson)

        val encoded = IGNORE_UNKNOWN_KEYS_JSON.encodeToString<V1ResolveObjectView>(response.resolve!!)

        assertTrue("\"type_\":\"person\"" in encoded, encoded)
    }

    @Test
    fun `unified sealed interface is resolved by its class discriminator`() {
        val response = IGNORE_UNKNOWN_KEYS_JSON.decodeFromString<UniSearchResponse>(searchResponseJson)

        val resolved = assertIs<UniPersonView>(response.resolve)
        assertEquals("name", resolved.person.name)
    }

    @Test
    fun `unified sealed interface survives a round trip`() {
        val response = IGNORE_UNKNOWN_KEYS_JSON.decodeFromString<UniSearchResponse>(searchResponseJson)

        val roundTripped =
            IGNORE_UNKNOWN_KEYS_JSON.decodeFromString<UniSearchResponse>(IGNORE_UNKNOWN_KEYS_JSON.encodeToString(response))

        assertEquals(response, roundTripped)
        assertIs<UniResolveObjectView>(roundTripped.resolve)
    }

    @Test
    fun `generated v1 notification data accepts every notification kind`() {
        val subclasses = V1NotificationData.serializer().descriptor.getElementDescriptor(1)
            .let { d -> (0 until d.elementsCount).map(d::getElementName) }
            .toSet()

        assertEquals(setOf("comment", "post", "private_message", "mod_action"), subclasses)
    }
}
