import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.respondError
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.Url
import io.ktor.http.headersOf
import it.vercruysse.lemmyapi.LemmyApiBaseController
import it.vercruysse.lemmyapi.LemmyApiClient
import it.vercruysse.lemmyapi.LemmyAuth
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.LemmyVersion
import it.vercruysse.lemmyapi.datatypes.GetComments
import it.vercruysse.lemmyapi.datatypes.GetModlog
import it.vercruysse.lemmyapi.datatypes.GetPosts
import it.vercruysse.lemmyapi.datatypes.ListCommentLikes
import it.vercruysse.lemmyapi.datatypes.ListCommunities
import it.vercruysse.lemmyapi.datatypes.ListMedia
import it.vercruysse.lemmyapi.datatypes.ListNotifications
import it.vercruysse.lemmyapi.datatypes.ListPersonContent
import it.vercruysse.lemmyapi.datatypes.ListPostLikes
import it.vercruysse.lemmyapi.datatypes.ListRegistrationApplications
import it.vercruysse.lemmyapi.datatypes.ListReports
import it.vercruysse.lemmyapi.datatypes.PaginationCursor
import it.vercruysse.lemmyapi.datatypes.Search
import it.vercruysse.lemmyapi.enums.NotificationDataType
import it.vercruysse.lemmyapi.enums.ReportType
import it.vercruysse.lemmyapi.exception.LemmyBadRequestException
import it.vercruysse.lemmyapi.exception.NotSupportedException
import it.vercruysse.lemmyapi.utils.LegacyPaging
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.json.JsonArray
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNull
import kotlin.test.assertTrue
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListCommunitiesResponse as Communities18
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.ListCommunitiesResponse as Communities0
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ListCommunitiesResponse as Communities11
import it.vercruysse.lemmyapi.v0.x19.x3.datatypes.ListCommunitiesResponse as Communities3
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListCommunitiesResponse as Communities4
import it.vercruysse.lemmyapi.v0.x19.x6.datatypes.ListCommunitiesResponse as Communities6

class LegacyPagingTest {
    private val legacyVersions = listOf("0.18.5", "0.19.0", "0.19.3", "0.19.4", "0.19.6", "0.19.11")

    @Test
    fun `cursor round trips to page number`() {
        assertEquals(1L, LegacyPaging.decode(null).getOrThrow())
        assertEquals(7L, LegacyPaging.decode(LegacyPaging.encode(7)).getOrThrow())
    }

    @Test
    fun `foreign or malformed cursors are rejected`() {
        for (cursor in listOf("abc", "p:", "p:0", "p:-1", "p:x", "p:2147483648", "p:9223372036854775807")) {
            val error = assertIs<LemmyBadRequestException>(LegacyPaging.decode(cursor).exceptionOrNull(), cursor)
            assertEquals(LegacyPaging.INVALID_CURSOR_ERROR, error.id)
        }
    }

    @Test
    fun `legacy wrappers emulate cursor pagination for listCommunities`() = runBlocking {
        val versions = listOf(
            "0.18.5" to Communities18.serializer().descriptor,
            "0.19.0" to Communities0.serializer().descriptor,
            "0.19.3" to Communities3.serializer().descriptor,
            "0.19.4" to Communities4.serializer().descriptor,
            "0.19.6" to Communities6.serializer().descriptor,
            "0.19.11" to Communities11.serializer().descriptor,
        )
        for ((version, descriptor) in versions) {
            val requestedPages = mutableListOf<String?>()
            val client = HttpClient(
                MockEngine { request ->
                    assertEquals("/api/v3/community/list", request.url.encodedPath, version)
                    assertNull(request.url.parameters["page_cursor"], version)
                    val page = request.url.parameters["page"]
                    requestedPages += page
                    respond(communities(descriptor, if (page == "3") 0 else 1).toString(), HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
                },
            )
            val apiClient = LemmyApiClient(client)
            try {
                val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyVersion(version)).getOrThrow()

                val first = api.listCommunities(ListCommunities(limit = 1)).getOrThrow()
                assertEquals(1, first.items.size, version)
                assertNull(first.prev_page, version)
                val second = api.listCommunities(ListCommunities(limit = 1, page_cursor = first.next_page)).getOrThrow()
                assertEquals(LegacyPaging.encode(1), second.prev_page, version)
                val third = api.listCommunities(ListCommunities(limit = 1, page_cursor = second.next_page)).getOrThrow()
                assertEquals(0, third.items.size, version)
                assertNull(third.next_page, version)
                assertEquals(LegacyPaging.encode(2), third.prev_page, version)
                assertEquals(listOf<String?>("1", "2", "3"), requestedPages, version)

                val requestCount = requestedPages.size
                assertIs<LemmyBadRequestException>(api.listCommunities(ListCommunities(page_cursor = "v1-cursor")).exceptionOrNull(), version)
                assertEquals(requestCount, requestedPages.size, version)
            } finally {
                apiClient.close()
                client.close()
            }
        }
    }

    @Test
    fun `legacy comment tree fetches have no next page`() = runBlocking {
        val versions = listOf(
            "0.18.5" to it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetCommentsResponse.serializer().descriptor,
            "0.19.3" to it.vercruysse.lemmyapi.v0.x19.x3.datatypes.GetCommentsResponse.serializer().descriptor,
            "0.19.11" to it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetCommentsResponse.serializer().descriptor,
        )
        for ((version, descriptor) in versions) {
            val client = HttpClient(
                MockEngine { request ->
                    assertEquals("8", request.url.parameters["max_depth"], version)
                    val comments = objectWith(descriptor, "comments" to JsonArray(listOf(sample(descriptor.element("comments").getElementDescriptor(0)))))
                    respond(comments.toString(), HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
                },
            )
            val apiClient = LemmyApiClient(client)
            try {
                val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyVersion(version)).getOrThrow()
                val tree = api.getComments(GetComments(post_id = 1, max_depth = 8)).getOrThrow()
                assertEquals(1, tree.items.size, version)
                assertNull(tree.next_page, version)

                val second = api.getComments(GetComments(post_id = 1, max_depth = 8, page_cursor = LegacyPaging.next(1, true))).getOrThrow()
                assertTrue(second.items.isEmpty(), version)
                assertNull(second.next_page, version)
                assertNull(second.prev_page, version)
            } finally {
                apiClient.close()
                client.close()
            }
        }
    }

    @Test
    fun `legacy wrappers translate the cursor to page on every paged endpoint`() = runBlocking {
        val endpoints: List<Pair<String, suspend LemmyApiBaseController.(PaginationCursor?) -> Result<*>>> = listOf(
            "getComments" to { getComments(GetComments(page_cursor = it)) },
            "search" to { search(Search(search_term = "test", page_cursor = it)) },
            "listReports" to { listReports(ListReports(type_ = ReportType.All, page_cursor = it)) },
            "listNotifications" to { listNotifications(ListNotifications(type_ = NotificationDataType.All, page_cursor = it)) },
            "listPersonContent" to { listPersonContent(ListPersonContent(person_id = 1, page_cursor = it)) },
            "listRegistrationApplications" to { listRegistrationApplications(ListRegistrationApplications(page_cursor = it)) },
            "listPostLikes" to { listPostLikes(ListPostLikes(post_id = 1, page_cursor = it)) },
            "listCommentLikes" to { listCommentLikes(ListCommentLikes(comment_id = 1, page_cursor = it)) },
            "listMedia" to { listMedia(ListMedia(page_cursor = it)) },
            "listMediaAdmin" to { listMediaAdmin(ListMedia(page_cursor = it)) },
            "getModlog" to { getModlog(GetModlog(page_cursor = it)) },
        )
        for (version in legacyVersions) {
            val requests = mutableListOf<Url>()
            // Fail every request, only the request parameters matter here
            val client = HttpClient(
                MockEngine { request ->
                    requests += request.url
                    respondError(HttpStatusCode.BadRequest)
                },
            )
            val apiClient = LemmyApiClient(client)
            try {
                val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyAuth.Bearer("test-token"), LemmyVersion(version)).getOrThrow()
                for ((name, call) in endpoints) {
                    requests.clear()
                    val result = api.call(LegacyPaging.encode(2))
                    if (result.exceptionOrNull() is NotSupportedException) continue
                    assertTrue(requests.isNotEmpty(), "$version $name made no request")
                    for (url in requests) {
                        assertEquals("2", url.parameters["page"], "$version $name: $url")
                        assertNull(url.parameters["page_cursor"], "$version $name: $url")
                    }

                    requests.clear()
                    assertIs<LemmyBadRequestException>(api.call("v1-cursor").exceptionOrNull(), "$version $name")
                    assertEquals(emptyList(), requests, "$version $name")
                }
            } finally {
                apiClient.close()
                client.close()
            }
        }
    }

    @Test
    fun `getPosts uses synthetic cursors on 0_18 and real cursors on 0_19`() = runBlocking {
        for (version in legacyVersions) {
            val requests = mutableListOf<Url>()
            val client = HttpClient(
                MockEngine { request ->
                    requests += request.url
                    respond("""{"posts":[],"next_page":"server-cursor"}""", HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
                },
            )
            val apiClient = LemmyApiClient(client)
            try {
                val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyVersion(version)).getOrThrow()
                if (version == "0.18.5") {
                    val result = api.getPosts(GetPosts(page_cursor = LegacyPaging.encode(2))).getOrThrow()
                    assertEquals("2", requests.single().parameters["page"])
                    assertNull(requests.single().parameters["page_cursor"])
                    assertNull(result.next_page)
                    assertEquals(LegacyPaging.encode(1), result.prev_page)
                } else {
                    val result = api.getPosts(GetPosts(page_cursor = "cursor")).getOrThrow()
                    assertEquals("cursor", requests.single().parameters["page_cursor"], version)
                    assertNull(requests.single().parameters["page"], version)
                    assertEquals("server-cursor", result.next_page, version)
                }
            } finally {
                apiClient.close()
                client.close()
            }
        }
    }

    @Test
    fun `v1 passes the real cursor through`() = runBlocking {
        val client = HttpClient(
            MockEngine { request ->
                assertEquals("/api/v4/community/list", request.url.encodedPath)
                assertEquals("cursor", request.url.parameters["page_cursor"])
                assertNull(request.url.parameters["page"])
                respond("""{"items":[],"next_page":"next","prev_page":"prev"}""", HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
            },
        )
        val apiClient = LemmyApiClient(client)
        try {
            val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyVersion("1.0.0")).getOrThrow()
            val result = api.listCommunities(ListCommunities(page_cursor = "cursor")).getOrThrow()
            assertEquals("next", result.next_page)
            assertEquals("prev", result.prev_page)
        } finally {
            apiClient.close()
            client.close()
        }
    }

    private fun communities(descriptor: SerialDescriptor, count: Int) = objectWith(
        descriptor,
        "communities" to JsonArray(List(count) { sample(descriptor.element("communities").getElementDescriptor(0)) }),
    )
}
