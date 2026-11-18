import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import it.vercruysse.lemmyapi.LemmyApiBaseController
import it.vercruysse.lemmyapi.LemmyApiClient
import it.vercruysse.lemmyapi.LemmyAuth
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.LemmyVersion
import it.vercruysse.lemmyapi.datatypes.CommunityView
import it.vercruysse.lemmyapi.datatypes.PostView
import it.vercruysse.lemmyapi.datatypes.ResolveObject
import it.vercruysse.lemmyapi.exception.LemmyBadRequestException
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.json.JsonObject
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class LegacyResolveObjectTest {
    private val versions = mapOf(
        "0.18.5" to it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ResolveObjectResponse.serializer().descriptor,
        "0.19.0" to it.vercruysse.lemmyapi.v0.x19.x0.datatypes.ResolveObjectResponse.serializer().descriptor,
        "0.19.11" to it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ResolveObjectResponse.serializer().descriptor,
    )

    private fun <T> withApi(version: String, body: JsonObject, block: suspend LemmyApiBaseController.() -> T): T = runBlocking {
        val client = HttpClient(
            MockEngine { request ->
                assertEquals("/api/v3/resolve_object", request.url.encodedPath)
                respond(body.toString(), HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
            },
        )
        val apiClient = LemmyApiClient(client)
        try {
            apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyAuth.Bearer("token"), LemmyVersion(version)).getOrThrow().block()
        } finally {
            apiClient.close()
            client.close()
        }
    }

    private fun only(d: SerialDescriptor, field: String) = JsonObject(mapOf(field to sample(d.element(field), nullable = false)))

    @Test
    fun `resolved object is returned as a ResolveObjectView pre 1_0`() {
        for ((version, d) in versions) {
            assertIs<PostView>(withApi(version, only(d, "post")) { resolveObject(ResolveObject("q")).getOrThrow() }, version)
            assertIs<CommunityView>(withApi(version, only(d, "community")) { resolveObject(ResolveObject("q")).getOrThrow() }, version)

            val empty = withApi(version, JsonObject(emptyMap())) { resolveObject(ResolveObject("q")) }
            assertEquals("couldnt_find_object", assertIs<LemmyBadRequestException>(empty.exceptionOrNull(), version).id)
        }
    }
}
