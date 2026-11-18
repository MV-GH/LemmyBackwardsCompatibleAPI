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
import it.vercruysse.lemmyapi.datatypes.CommentReportView
import it.vercruysse.lemmyapi.datatypes.ListReports
import it.vercruysse.lemmyapi.datatypes.PostReportView
import it.vercruysse.lemmyapi.enums.ReportType
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class LegacyReportFiltersTest {
    private class Descriptors(val posts: SerialDescriptor, val comments: SerialDescriptor, val privateMessages: SerialDescriptor)

    private val versions = mapOf(
        "0.18.5" to Descriptors(
            it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListPostReportsResponse.serializer().descriptor,
            it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListCommentReportsResponse.serializer().descriptor,
            it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListPrivateMessageReportsResponse.serializer().descriptor,
        ),
        "0.19.0" to Descriptors(
            it.vercruysse.lemmyapi.v0.x19.x0.datatypes.ListPostReportsResponse.serializer().descriptor,
            it.vercruysse.lemmyapi.v0.x19.x0.datatypes.ListCommentReportsResponse.serializer().descriptor,
            it.vercruysse.lemmyapi.v0.x19.x0.datatypes.ListPrivateMessageReportsResponse.serializer().descriptor,
        ),
        "0.19.11" to Descriptors(
            it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ListPostReportsResponse.serializer().descriptor,
            it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ListCommentReportsResponse.serializer().descriptor,
            it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ListPrivateMessageReportsResponse.serializer().descriptor,
        ),
    )

    private fun postReports(d: SerialDescriptor, postIds: List<Long>): JsonObject {
        val view = d.element("post_reports").getElementDescriptor(0)
        return objectWith(d, "post_reports" to JsonArray(postIds.map { objectWith(view, "post" to objectWith(view.element("post"), "id" to JsonPrimitive(it))) }))
    }

    private fun commentReports(d: SerialDescriptor, postIds: List<Long>): JsonObject {
        val view = d.element("comment_reports").getElementDescriptor(0)
        return objectWith(d, "comment_reports" to JsonArray(postIds.map { objectWith(view, "comment" to objectWith(view.element("comment"), "post_id" to JsonPrimitive(it))) }))
    }

    private fun privateMessageReports(d: SerialDescriptor, count: Int): JsonObject =
        objectWith(d, "private_message_reports" to JsonArray(List(count) { sample(d.element("private_message_reports").getElementDescriptor(0)) }))

    /** Serves page 1 with reports on post 2 only and page 2 with reports on post 1, for every report type. */
    private fun withApi(version: String, d: Descriptors, block: suspend LemmyApiBaseController.() -> Unit) = runBlocking {
        val client = HttpClient(
            MockEngine { request ->
                val postIds = if (request.url.parameters["page"] == "1") listOf(2L) else listOf(1L, 2L)
                val body = when (request.url.encodedPath) {
                    "/api/v3/post/report/list" -> postReports(d.posts, postIds)
                    "/api/v3/comment/report/list" -> commentReports(d.comments, postIds)
                    "/api/v3/private_message/report/list" -> privateMessageReports(d.privateMessages, 1)
                    else -> error("Unexpected request: ${request.url}")
                }
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

    @Test
    fun `post filter keeps paging when a page has no matches`() {
        for ((version, d) in versions) {
            withApi(version, d) {
                for (type in listOf(ReportType.Posts, ReportType.Comments, ReportType.All)) {
                    val first = listReports(ListReports(type_ = type, post_id = 1)).getOrThrow()
                    assertTrue(first.items.isEmpty(), "$version $type")
                    assertNotNull(first.next_page, "$version $type")

                    val second = listReports(ListReports(type_ = type, post_id = 1, page_cursor = first.next_page)).getOrThrow()
                    val postIds = second.items.map {
                        when (it) {
                            is PostReportView -> it.post.id
                            is CommentReportView -> it.comment.post_id
                            else -> error("$version $type: unexpected $it")
                        }
                    }
                    assertEquals(if (type == ReportType.All) listOf(1L, 1L) else listOf(1L), postIds, "$version $type")
                }
            }
        }
    }

    @Test
    fun `private message reports are empty without paging with a post or community filter`() {
        for ((version, d) in versions) {
            withApi(version, d) {
                assertEquals(1, listReports(ListReports(type_ = ReportType.PrivateMessages)).getOrThrow().items.size, version)

                for (form in listOf(ListReports(type_ = ReportType.PrivateMessages, community_id = 3), ListReports(type_ = ReportType.PrivateMessages, post_id = 1))) {
                    val filtered = listReports(form).getOrThrow()
                    assertTrue(filtered.items.isEmpty(), version)
                    assertNull(filtered.next_page, version)
                }
            }
        }
    }
}
