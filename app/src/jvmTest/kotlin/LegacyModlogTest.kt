import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import it.vercruysse.lemmyapi.LemmyApiClient
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.LemmyVersion
import it.vercruysse.lemmyapi.datatypes.GetModlog
import it.vercruysse.lemmyapi.enums.ModlogActionType
import it.vercruysse.lemmyapi.enums.ModlogKind
import it.vercruysse.lemmyapi.utils.LegacyPaging
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetModlogResponse as Modlog18
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetModlogResponse as Modlog0
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetModlogResponse as Modlog11
import it.vercruysse.lemmyapi.v0.x19.x3.datatypes.GetModlogResponse as Modlog3
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetModlogResponse as Modlog4
import it.vercruysse.lemmyapi.v0.x19.x6.datatypes.GetModlogResponse as Modlog6

class LegacyModlogTest {
    private val versions = listOf(
        "0.18.5" to Modlog18.serializer().descriptor,
        "0.19.0" to Modlog0.serializer().descriptor,
        "0.19.3" to Modlog3.serializer().descriptor,
        "0.19.4" to Modlog4.serializer().descriptor,
        "0.19.6" to Modlog6.serializer().descriptor,
        "0.19.11" to Modlog11.serializer().descriptor,
    )

    private fun entry(descriptor: SerialDescriptor, list: String, action: String, vararg fields: Pair<String, JsonElement>): JsonElement {
        val view = sample(descriptor.element(list).getElementDescriptor(0)) as JsonObject
        val inner = view[action] as JsonObject
        return JsonArray(listOf(JsonObject(view + (action to JsonObject(inner + fields)))))
    }

    @Test
    fun `pre 1_0 modlog categories are flattened newest first`() = runBlocking {
        for ((version, descriptor) in versions) {
            val response = objectWith(
                descriptor,
                "removed_posts" to entry(
                    descriptor,
                    "removed_posts",
                    "mod_remove_post",
                    "id" to JsonPrimitive(1),
                    "removed" to JsonPrimitive(true),
                    "reason" to JsonPrimitive("spam"),
                    "when_" to JsonPrimitive("2024-01-01T00:00:03Z"),
                ),
                "banned" to entry(
                    descriptor,
                    "banned",
                    "mod_ban",
                    "id" to JsonPrimitive(1),
                    "banned" to JsonPrimitive(false),
                    "when_" to JsonPrimitive("2024-01-01T00:00:03.5"),
                ),
                "featured_posts" to entry(
                    descriptor,
                    "featured_posts",
                    "mod_feature_post",
                    "id" to JsonPrimitive(2),
                    "featured" to JsonPrimitive(true),
                    "is_featured_community" to JsonPrimitive(true),
                    "when_" to JsonPrimitive("2024-01-01T00:00:01.123456Z"),
                ),
            )
            val client = HttpClient(
                MockEngine { request ->
                    assertEquals("/api/v3/modlog", request.url.encodedPath)
                    assertEquals("2", request.url.parameters["page"], version)
                    respond(response.toString(), HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
                },
            )
            val apiClient = LemmyApiClient(client)
            try {
                val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyVersion(version)).getOrThrow()
                assertTrue(api.FF.modlog(), version)
                val result = api.getModlog(GetModlog(page_cursor = LegacyPaging.encode(2))).getOrThrow()
                val log = result.items.map { it.modlog }
                assertEquals(listOf(ModlogKind.AdminBan, ModlogKind.ModRemovePost, ModlogKind.ModFeaturePostCommunity), log.map { it.kind }, version)
                assertEquals(listOf(true, false, false), log.map { it.is_revert }, version)
                assertEquals("spam", log[1].reason)
                assertEquals(1L, result.items[1].target_post?.id)
                assertEquals(LegacyPaging.encode(3), result.next_page)
                assertEquals(LegacyPaging.encode(1), result.prev_page)
            } finally {
                apiClient.close()
                client.close()
            }
        }
    }

    @Test
    fun `1_0 only modlog types return nothing pre 1_0`() = runBlocking {
        val client = HttpClient(MockEngine { error("Unexpected request: ${it.url}") })
        val apiClient = LemmyApiClient(client)
        try {
            val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyVersion("0.19.11")).getOrThrow()
            val result = api.getModlog(GetModlog(type_ = ModlogActionType.ModWarnPost)).getOrThrow()
            assertEquals(emptyList(), result.items)
            assertEquals(null, result.next_page)
        } finally {
            apiClient.close()
            client.close()
        }
    }
}
