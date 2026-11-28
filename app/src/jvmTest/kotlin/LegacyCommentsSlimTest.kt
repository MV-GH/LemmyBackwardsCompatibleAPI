import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import it.vercruysse.lemmyapi.LemmyApiClient
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.LemmyVersion
import it.vercruysse.lemmyapi.datatypes.GetComments
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.JsonArray
import kotlin.test.Test
import kotlin.test.assertEquals
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetCommentsResponse as Comments18
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetCommentsResponse as Comments0
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetCommentsResponse as Comments11
import it.vercruysse.lemmyapi.v0.x19.x3.datatypes.GetCommentsResponse as Comments3
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetCommentsResponse as Comments4
import it.vercruysse.lemmyapi.v0.x19.x6.datatypes.GetCommentsResponse as Comments6

class LegacyCommentsSlimTest {
    @Test
    fun `legacy slim comments are the full comments without post and community`() = runBlocking {
        val versions = listOf(
            "0.18.5" to Comments18.serializer().descriptor,
            "0.19.0" to Comments0.serializer().descriptor,
            "0.19.3" to Comments3.serializer().descriptor,
            "0.19.4" to Comments4.serializer().descriptor,
            "0.19.6" to Comments6.serializer().descriptor,
            "0.19.11" to Comments11.serializer().descriptor,
        )
        for ((version, descriptor) in versions) {
            val comment = sample(descriptor.element("comments").getElementDescriptor(0))
            val response = objectWith(descriptor, "comments" to JsonArray(listOf(comment)))
            val client = HttpClient(
                MockEngine { request ->
                    assertEquals("/api/v3/comment/list", request.url.encodedPath)
                    respond(response.toString(), HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
                },
            )
            val apiClient = LemmyApiClient(client)
            try {
                val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyVersion(version)).getOrThrow()
                val full = api.getComments(GetComments()).getOrThrow()
                val slim = api.getCommentsSlim(GetComments()).getOrThrow()
                assertEquals(full.items.map { it.comment }, slim.items.map { it.comment }, version)
                assertEquals(full.items.map { it.creator }, slim.items.map { it.creator }, version)
                assertEquals(full.next_page, slim.next_page, version)
            } finally {
                apiClient.close()
                client.close()
            }
        }
    }
}
