import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.TextContent
import io.ktor.http.headersOf
import it.vercruysse.lemmyapi.LemmyApiClient
import it.vercruysse.lemmyapi.LemmyAuth
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.LemmyVersion
import it.vercruysse.lemmyapi.datatypes.EditCustomEmoji
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlin.test.Test
import kotlin.test.assertEquals

class LegacyCustomEmojiEditTest {
    private val versions = mapOf(
        "0.18.5" to it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetSiteResponse.serializer().descriptor,
        "0.19.0" to it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetSiteResponse.serializer().descriptor,
        "0.19.11" to it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetSiteResponse.serializer().descriptor,
    )

    private fun site(descriptor: SerialDescriptor) = run {
        val view = descriptor.element("custom_emojis").getElementDescriptor(0)
        val emoji = objectWith(
            view.element("custom_emoji"),
            "id" to JsonPrimitive(5),
            "category" to JsonPrimitive("old category"),
            "image_url" to JsonPrimitive("https://example.com/old.png"),
            "alt_text" to JsonPrimitive("old alt"),
        )
        val keyword = objectWith(view.element("keywords").getElementDescriptor(0), "keyword" to JsonPrimitive("old keyword"))
        objectWith(descriptor, "custom_emojis" to JsonArray(listOf(objectWith(view, "custom_emoji" to emoji, "keywords" to JsonArray(listOf(keyword))))))
    }

    @Test
    fun `partial custom emoji edits keep the current values on pre 1_0`() = runBlocking {
        for ((version, descriptor) in versions) {
            var sent: String? = null
            val client = HttpClient(
                MockEngine { request ->
                    when (request.url.encodedPath) {
                        "/api/v3/site" -> respond(site(descriptor).toString(), HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))

                        "/api/v3/custom_emoji" -> {
                            sent = (request.body as TextContent).text
                            val view = descriptor.element("custom_emojis").getElementDescriptor(0)
                            respond("""{"custom_emoji":${sample(view)}}""", HttpStatusCode.OK, headersOf(HttpHeaders.ContentType, "application/json"))
                        }

                        else -> error("Unexpected request: ${request.url}")
                    }
                },
            )
            val apiClient = LemmyApiClient(client)
            try {
                val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyAuth.Bearer("token"), LemmyVersion(version)).getOrThrow()
                api.editCustomEmoji(EditCustomEmoji(id = 5, alt_text = "new alt")).getOrThrow()

                val body = Json.parseToJsonElement(sent!!).jsonObject
                assertEquals("old category", body["category"]!!.jsonPrimitive.content, version)
                assertEquals("https://example.com/old.png", body["image_url"]!!.jsonPrimitive.content, version)
                assertEquals("new alt", body["alt_text"]!!.jsonPrimitive.content, version)
                assertEquals(listOf("old keyword"), body["keywords"]!!.jsonArray.map { it.jsonPrimitive.content }, version)
            } finally {
                apiClient.close()
                client.close()
            }
        }
    }
}
