import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.TextContent
import io.ktor.http.headersOf
import it.vercruysse.lemmyapi.LemmyApiBaseController
import it.vercruysse.lemmyapi.LemmyApiClient
import it.vercruysse.lemmyapi.LemmyAuth
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.LemmyVersion
import it.vercruysse.lemmyapi.datatypes.CreateCommunity
import it.vercruysse.lemmyapi.datatypes.EditCommunity
import it.vercruysse.lemmyapi.enums.CommunityVisibility
import it.vercruysse.lemmyapi.exception.LemmyBadRequestException
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class LegacyCommunityVisibilityTest {
    private class Descriptors(val community: SerialDescriptor, val getCommunity: SerialDescriptor, val site: SerialDescriptor)

    private val versions = mapOf(
        "0.18.5" to Descriptors(
            it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommunityResponse.serializer().descriptor,
            it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetCommunityResponse.serializer().descriptor,
            it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetSiteResponse.serializer().descriptor,
        ),
        "0.19.0" to Descriptors(
            it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CommunityResponse.serializer().descriptor,
            it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetCommunityResponse.serializer().descriptor,
            it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetSiteResponse.serializer().descriptor,
        ),
        "0.19.11" to Descriptors(
            it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CommunityResponse.serializer().descriptor,
            it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetCommunityResponse.serializer().descriptor,
            it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetSiteResponse.serializer().descriptor,
        ),
    )

    /** Like [objectWith], also for nullable descriptors. */
    private fun obj(descriptor: SerialDescriptor, vararg fields: Pair<String, JsonElement>): JsonObject =
        JsonObject((sample(descriptor, nullable = false) as JsonObject) + fields)

    private fun communityResponse(d: SerialDescriptor, hidden: Boolean): JsonObject {
        val view = d.element("community_view")
        return obj(d, "community_view" to obj(view, "community" to obj(view.element("community"), "id" to JsonPrimitive(7), "hidden" to JsonPrimitive(hidden))))
    }

    private fun site(d: SerialDescriptor, admin: Boolean): JsonObject {
        val myUser = d.element("my_user")
        val view = myUser.element("local_user_view")
        val person = view.element("person")
        val localUser = view.element("local_user")
        val adminFlag = "admin" to JsonPrimitive(admin)
        return obj(
            d,
            "my_user" to obj(
                myUser,
                "local_user_view" to obj(
                    view,
                    "person" to if (person.getElementIndex("admin") >= 0) obj(person, adminFlag) else obj(person),
                    "local_user" to if (localUser.getElementIndex("admin") >= 0) obj(localUser, adminFlag) else obj(localUser),
                ),
            ),
        )
    }

    private class Server(val requests: MutableList<String> = mutableListOf(), val hides: MutableList<Boolean> = mutableListOf())

    /** Runs [call] against a server whose community 7 is [hidden] and whose user is [admin] or not. */
    private fun <T> run(
        version: String,
        d: Descriptors,
        hidden: Boolean,
        admin: Boolean = true,
        hideFails: Boolean = false,
        call: suspend LemmyApiBaseController.() -> T,
    ): Pair<Server, T> = runBlocking {
        val server = Server()
        val client = HttpClient(
            MockEngine { request ->
                server.requests += "${request.method.value} ${request.url.encodedPath}"
                val body = when {
                    request.url.encodedPath == "/api/v3/site" -> site(d.site, admin)

                    request.url.encodedPath == "/api/v3/community" && request.method == HttpMethod.Get ->
                        obj(d.getCommunity, "community_view" to communityResponse(d.community, hidden)["community_view"]!!)

                    request.url.encodedPath == "/api/v3/community" -> communityResponse(d.community, hidden)

                    request.url.encodedPath == "/api/v3/community/hide" && hideFails ->
                        return@MockEngine respond("""{"error":"unknown"}""", HttpStatusCode.BadRequest, headersOf(HttpHeaders.ContentType, "application/json"))

                    request.url.encodedPath == "/api/v3/community/hide" -> {
                        val form = Json.parseToJsonElement((request.body as TextContent).text).jsonObject
                        assertEquals("7", form["community_id"]!!.jsonPrimitive.content, version)
                        server.hides += form["hidden"]!!.jsonPrimitive.content.toBoolean()
                        JsonObject(emptyMap())
                    }

                    else -> error("Unexpected request: ${request.method.value} ${request.url}")
                }
                respond(body.toString(), HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
            },
        )
        val apiClient = LemmyApiClient(client)
        try {
            val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyAuth.Bearer("token"), LemmyVersion(version)).getOrThrow()
            server to api.call()
        } finally {
            apiClient.close()
            client.close()
        }
    }

    @Test
    fun `unlisted visibility hides the community pre 1_0`() {
        for ((version, d) in versions) {
            val (edit, edited) = run(version, d, hidden = false) {
                editCommunity(EditCommunity(community_id = 7, visibility = CommunityVisibility.Unlisted)).getOrThrow()
            }
            assertEquals(listOf(true), edit.hides, version)
            assertEquals(CommunityVisibility.Unlisted, edited.community_view.community.visibility, version)

            val (create, created) = run(version, d, hidden = false) {
                createCommunity(CreateCommunity(name = "c", title = "c", visibility = CommunityVisibility.Unlisted)).getOrThrow()
            }
            assertEquals(listOf(true), create.hides, version)
            assertEquals(CommunityVisibility.Unlisted, created.community_view.community.visibility, version)
        }
    }

    @Test
    fun `public visibility unhides a hidden community pre 1_0`() {
        for ((version, d) in versions) {
            val (server, edited) = run(version, d, hidden = true) {
                editCommunity(EditCommunity(community_id = 7, visibility = CommunityVisibility.Public)).getOrThrow()
            }
            assertEquals(listOf(false), server.hides, version)
            assertEquals(CommunityVisibility.Public, edited.community_view.community.visibility, version)
        }
    }

    @Test
    fun `hidden state is left alone when nothing changes pre 1_0`() {
        for ((version, d) in versions) {
            val (noVisibility, _) = run(version, d, hidden = true) {
                editCommunity(EditCommunity(community_id = 7, title = "t")).getOrThrow()
            }
            assertEquals(listOf("PUT /api/v3/community"), noVisibility.requests, version)

            val (alreadyHidden, _) = run(version, d, hidden = true) {
                editCommunity(EditCommunity(community_id = 7, visibility = CommunityVisibility.Unlisted)).getOrThrow()
            }
            assertTrue(alreadyHidden.hides.isEmpty(), version)

            val (unsupported, _) = run(version, d, hidden = true) {
                editCommunity(EditCommunity(community_id = 7, visibility = CommunityVisibility.Private)).getOrThrow()
            }
            assertTrue(unsupported.hides.isEmpty(), version)
        }
    }

    @Test
    fun `non admins can't change the hidden state and nothing is created or edited pre 1_0`() {
        for ((version, d) in versions) {
            val (create, created) = run(version, d, hidden = false, admin = false) {
                createCommunity(CreateCommunity(name = "c", title = "c", visibility = CommunityVisibility.Unlisted))
            }
            assertEquals("not_an_admin", assertIs<LemmyBadRequestException>(created.exceptionOrNull(), version).id)
            assertTrue(create.requests.none { it == "POST /api/v3/community" }, "$version ${create.requests}")

            val (edit, edited) = run(version, d, hidden = true, admin = false) {
                editCommunity(EditCommunity(community_id = 7, visibility = CommunityVisibility.Public))
            }
            assertIs<LemmyBadRequestException>(edited.exceptionOrNull(), version)
            assertTrue(edit.requests.none { it == "PUT /api/v3/community" }, "$version ${edit.requests}")

            val (unchanged, result) = run(version, d, hidden = false, admin = false) {
                editCommunity(EditCommunity(community_id = 7, visibility = CommunityVisibility.Public))
            }
            assertTrue(result.isSuccess, version)
            assertTrue(unchanged.hides.isEmpty(), version)
        }
    }

    @Test
    fun `public and unlisted are supported entries pre 1_0`() {
        LemmyApiClient().use { client ->
            for (version in versions.keys) {
                val api = client.connectForVersion(LemmyInstance("lemmy.ml"), LemmyVersion(version)).getOrThrow()
                val entries = api.getSupportedEntries<CommunityVisibility>()
                assertTrue(entries.containsAll(listOf(CommunityVisibility.Public, CommunityVisibility.Unlisted)), "$version $entries")
            }
        }
    }

    @Test
    fun `created community is returned when hiding it fails pre 1_0`() {
        for ((version, d) in versions) {
            val (server, created) = run(version, d, hidden = false, hideFails = true) {
                createCommunity(CreateCommunity(name = "c", title = "c", visibility = CommunityVisibility.Unlisted))
            }
            assertTrue(server.requests.contains("POST /api/v3/community/hide") || server.requests.contains("PUT /api/v3/community/hide"), "$version ${server.requests}")
            assertEquals(CommunityVisibility.Public, created.getOrThrow().community_view.community.visibility, version)
        }
    }
}
