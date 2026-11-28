import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import it.vercruysse.lemmyapi.LemmyApiClient
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.LemmyVersion
import it.vercruysse.lemmyapi.datatypes.ListTaglines
import it.vercruysse.lemmyapi.utils.LegacyPaging
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetSiteResponse as Site18
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetSiteResponse as Site0
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetSiteResponse as Site11
import it.vercruysse.lemmyapi.v0.x19.x3.datatypes.GetSiteResponse as Site3
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetSiteResponse as Site4
import it.vercruysse.lemmyapi.v0.x19.x6.datatypes.GetSiteResponse as Site6

class LegacyTaglinesTest {
    private fun tagline(id: Int): JsonElement =
        Json.parseToJsonElement("""{"id":$id,"local_site_id":1,"content":"tagline $id","published":"2024-01-01T00:00:00Z"}""")

    @Test
    fun `legacy taglines come from the site and are paged client side`() = runBlocking {
        val versions = listOf(
            "0.18.5" to Site18.serializer().descriptor,
            "0.19.0" to Site0.serializer().descriptor,
            "0.19.3" to Site3.serializer().descriptor,
            "0.19.4" to Site4.serializer().descriptor,
            "0.19.6" to Site6.serializer().descriptor,
            "0.19.11" to Site11.serializer().descriptor,
        )
        for ((version, descriptor) in versions) {
            val site = objectWith(descriptor, "taglines" to JsonArray(listOf(tagline(1), tagline(2), tagline(3))))
            val client = HttpClient(
                MockEngine { request ->
                    assertEquals("/api/v3/site", request.url.encodedPath)
                    respond(site.toString(), HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
                },
            )
            val apiClient = LemmyApiClient(client)
            try {
                val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyVersion(version)).getOrThrow()
                val all = api.listTaglines(ListTaglines()).getOrThrow()
                assertEquals(listOf("tagline 1", "tagline 2", "tagline 3"), all.items.map { it.content }, version)
                assertNull(all.next_page)
                val second = api.listTaglines(ListTaglines(page_cursor = LegacyPaging.encode(2), limit = 2)).getOrThrow()
                assertEquals(listOf(3L), second.items.map { it.id }, version)
                assertNull(second.next_page)
                assertEquals(LegacyPaging.encode(1), second.prev_page)
                val far = api.listTaglines(ListTaglines(page_cursor = LegacyPaging.encode(Int.MAX_VALUE.toLong()), limit = Long.MAX_VALUE)).getOrThrow()
                assertEquals(emptyList(), far.items, version)
            } finally {
                apiClient.close()
                client.close()
            }
        }
    }
}
