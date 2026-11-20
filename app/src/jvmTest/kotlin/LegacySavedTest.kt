import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import it.vercruysse.lemmyapi.Identity
import it.vercruysse.lemmyapi.LemmyApiClient
import it.vercruysse.lemmyapi.LemmyAuth
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.LemmyVersion
import it.vercruysse.lemmyapi.datatypes.CommentView
import it.vercruysse.lemmyapi.datatypes.ListPersonContent
import it.vercruysse.lemmyapi.datatypes.ListPersonSaved
import it.vercruysse.lemmyapi.datatypes.PostView
import it.vercruysse.lemmyapi.enums.PersonContentType
import it.vercruysse.lemmyapi.exception.LemmyBadRequestException
import it.vercruysse.lemmyapi.exception.NotSupportedException
import it.vercruysse.lemmyapi.utils.LegacyPaging
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNull
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPersonDetailsResponse as Details18
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetSiteResponse as Site18
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetPersonDetailsResponse as Details0
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetSiteResponse as Site0
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetPersonDetailsResponse as Details11
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetSiteResponse as Site11
import it.vercruysse.lemmyapi.v0.x19.x3.datatypes.GetPersonDetailsResponse as Details3
import it.vercruysse.lemmyapi.v0.x19.x3.datatypes.GetSiteResponse as Site3
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPersonDetailsResponse as Details4
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetSiteResponse as Site4
import it.vercruysse.lemmyapi.v0.x19.x6.datatypes.GetPersonDetailsResponse as Details6
import it.vercruysse.lemmyapi.v0.x19.x6.datatypes.GetSiteResponse as Site6

class LegacySavedTest {
    @Test
    fun `legacy wrappers request and map saved content with cursor and type filters`() = runBlocking {
        val versions = listOf(
            Triple("0.18.5", Site18.serializer().descriptor, Details18.serializer().descriptor),
            Triple("0.19.0", Site0.serializer().descriptor, Details0.serializer().descriptor),
            Triple("0.19.3", Site3.serializer().descriptor, Details3.serializer().descriptor),
            Triple("0.19.4", Site4.serializer().descriptor, Details4.serializer().descriptor),
            Triple("0.19.6", Site6.serializer().descriptor, Details6.serializer().descriptor),
            Triple("0.19.11", Site11.serializer().descriptor, Details11.serializer().descriptor),
            Triple("0.19.21", Site11.serializer().descriptor, Details11.serializer().descriptor),
        )
        for ((version, siteDescriptor, detailsDescriptor) in versions) {
            val site = objectWith(siteDescriptor, "my_user" to sample(siteDescriptor.element("my_user"), nullable = false))
            val comment = sample(detailsDescriptor.element("comments").getElementDescriptor(0)) as JsonObject
            val post = sample(detailsDescriptor.element("posts").getElementDescriptor(0)) as JsonObject
            // Mixed fraction lengths and zones to check the timestamps are compared chronologically, not as plain strings
            val details = objectWith(
                detailsDescriptor,
                "comments" to JsonArray(
                    listOf(
                        comment.withPublished("comment", 1, "2024-01-01T00:00:01Z"),
                        comment.withPublished("comment", 3, "2024-01-01T00:00:03.5"),
                    ),
                ),
                "posts" to JsonArray(
                    listOf(
                        post.withPublished("post", 4, "2024-01-01T00:00:03.75+00:00"),
                        post.withPublished("post", 2, "2024-01-01T00:00:02.123456Z"),
                    ),
                ),
            )
            val paths = mutableListOf<String>()
            val client = HttpClient(
                MockEngine { request ->
                    paths += request.url.encodedPath
                    if (version == "0.18.5") {
                        assertEquals("test-token", request.url.parameters["auth"])
                    } else {
                        assertEquals("Bearer test-token", request.headers[HttpHeaders.Authorization])
                    }
                    val response = when (request.url.encodedPath) {
                        "/api/v3/site" -> site

                        "/api/v3/user" -> {
                            assertEquals("1", request.url.parameters["person_id"])
                            assertEquals("true", request.url.parameters["saved_only"])
                            assertEquals("3", request.url.parameters["page"])
                            assertEquals("1", request.url.parameters["limit"])
                            details
                        }

                        else -> error("Unexpected request: ${request.url}")
                    }
                    respond(response.toString(), HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
                },
            )
            val apiClient = LemmyApiClient(client)
            try {
                val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyAuth.Bearer("test-token"), LemmyVersion(version)).getOrThrow()
                val result = api.listPersonSaved(ListPersonSaved(page_cursor = LegacyPaging.encode(3), limit = 1)).getOrThrow()
                assertEquals(listOf(4L, 3L, 2L, 1L), result.items.map { (it as Identity).id }, version)
                assertIs<PostView>(result.items[0], version)
                assertIs<CommentView>(result.items[1], version)
                assertIs<PostView>(result.items[2], version)
                assertIs<CommentView>(result.items[3], version)
                assertEquals(LegacyPaging.encode(4), result.next_page)
                assertEquals(LegacyPaging.encode(2), result.prev_page)
                assertEquals(listOf("/api/v3/site", "/api/v3/user"), paths)
                val posts = api.listPersonSaved(ListPersonSaved(type_ = PersonContentType.Posts, page_cursor = LegacyPaging.encode(3), limit = 1)).getOrThrow()
                assertEquals(listOf(4L, 2L), posts.items.map { assertIs<PostView>(it).id })
                val comments = api.listPersonSaved(ListPersonSaved(type_ = PersonContentType.Comments, page_cursor = LegacyPaging.encode(3), limit = 1)).getOrThrow()
                assertEquals(listOf(3L, 1L), comments.items.map { assertIs<CommentView>(it).id })
                val requestCount = paths.size
                assertIs<NotSupportedException>(api.listPersonSaved(ListPersonSaved(search_term = "test")).exceptionOrNull())
                assertEquals(requestCount, paths.size)
            } finally {
                apiClient.close()
                client.close()
            }
        }
    }

    @Test
    fun `legacy wrappers weave person content newest first`() = runBlocking {
        val versions = listOf(
            "0.18.5" to Details18.serializer().descriptor,
            "0.19.0" to Details0.serializer().descriptor,
            "0.19.3" to Details3.serializer().descriptor,
            "0.19.4" to Details4.serializer().descriptor,
            "0.19.6" to Details6.serializer().descriptor,
            "0.19.11" to Details11.serializer().descriptor,
        )
        for ((version, detailsDescriptor) in versions) {
            val comment = sample(detailsDescriptor.element("comments").getElementDescriptor(0)) as JsonObject
            val post = sample(detailsDescriptor.element("posts").getElementDescriptor(0)) as JsonObject
            val details = objectWith(
                detailsDescriptor,
                "comments" to JsonArray(listOf(comment.withPublished("comment", 1, "2024-01-01T00:00:01Z"), comment.withPublished("comment", 3, "2024-01-01T00:00:03Z"))),
                "posts" to JsonArray(listOf(post.withPublished("post", 2, "2024-01-01T00:00:02Z"))),
            )
            val client = HttpClient(
                MockEngine { request ->
                    assertEquals("/api/v3/user", request.url.encodedPath)
                    respond(details.toString(), HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
                },
            )
            val apiClient = LemmyApiClient(client)
            try {
                val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyVersion(version)).getOrThrow()
                val result = api.listPersonContent(ListPersonContent(person_id = 1)).getOrThrow()
                assertEquals(listOf(3L, 2L, 1L), result.items.map { (it as Identity).id }, version)
                assertIs<PostView>(result.items[1], version)
            } finally {
                apiClient.close()
                client.close()
            }
        }
    }

    @Test
    fun `missing authentication fails before requesting saved content`() = runBlocking {
        val siteDescriptor = Site11.serializer().descriptor
        val site = objectWith(siteDescriptor)
        val paths = mutableListOf<String>()
        val client = HttpClient(
            MockEngine { request ->
                paths += request.url.encodedPath
                respond(site.toString(), HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
            },
        )
        val apiClient = LemmyApiClient(client)
        try {
            val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyVersion("0.19.11")).getOrThrow()
            val error = assertIs<LemmyBadRequestException>(api.listPersonSaved(ListPersonSaved()).exceptionOrNull())
            assertEquals(401, error.statusCode)
            assertEquals(listOf("/api/v3/site"), paths)
        } finally {
            apiClient.close()
            client.close()
        }
    }

    @Test
    fun `v1 uses cursor and does not send legacy page`() = runBlocking {
        val client = HttpClient(
            MockEngine { request ->
                assertEquals("/api/v4/account/saved", request.url.encodedPath)
                assertEquals("cursor", request.url.parameters["page_cursor"])
                assertEquals("2", request.url.parameters["limit"])
                assertNull(request.url.parameters["page"])
                respond("""{"items":[]}""", HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
            },
        )
        val apiClient = LemmyApiClient(client)
        try {
            val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyVersion("1.0.0")).getOrThrow()
            api.listPersonSaved(ListPersonSaved(page_cursor = "cursor", limit = 2)).getOrThrow()
            Unit
        } finally {
            apiClient.close()
            client.close()
        }
    }
}

private fun JsonObject.withPublished(key: String, id: Long, published: String): JsonObject {
    val inner = this.getValue(key) as JsonObject
    return JsonObject(this + (key to JsonObject(inner + mapOf("id" to JsonPrimitive(id), "published" to JsonPrimitive(published)))))
}
