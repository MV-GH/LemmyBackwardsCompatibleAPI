import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import io.ktor.utils.io.ByteReadChannel
import it.vercruysse.lemmyapi.LemmyApi
import it.vercruysse.lemmyapi.coreHttpClient
import it.vercruysse.lemmyapi.datatypes.GetPosts
import it.vercruysse.lemmyapi.dto.PAGE_CURSOR_GUARD
import it.vercruysse.lemmyapi.ktorJson
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.Test

class PostsListPageParamTest {

    companion object {
        @BeforeAll
        @JvmStatic
        fun setUp() {
            LemmyApi.defaultClient = getMockClient()
        }

        @AfterAll
        @JvmStatic
        fun tearDown() {
            LemmyApi.defaultClient = coreHttpClient
        }


        private fun getValidationMocKEngine(): MockEngine {
            return MockEngine { request ->
                val url = request.url

                var success = true


                // Rules:
                // never send both page and page_cursor,
                // page_cursor takes priority
                // never send pagination_guard
                // work with null and value
                if (url.encodedPath != "/api/v3/post/list") {
                    success = false
                } else if (url.parameters.contains("page_cursor") && url.parameters.contains("page")) {
                    success = false
                } else if (url.parameters["page_cursor"] == PAGE_CURSOR_GUARD) {
                    success = false
                }

                if (success) {
                    respond(
                        content = ByteReadChannel("""{"posts": [], "next_page": null}"""),
                        status = HttpStatusCode.OK,
                        headers = headersOf(HttpHeaders.ContentType, "application/json")
                    )
                } else {
                    respond(
                        content = ByteReadChannel("Failed validation"),
                        status = HttpStatusCode.BadRequest,
                        headers = headersOf(HttpHeaders.ContentType, "application/json")
                    )
                }
            }
        }

        private fun getMockClient(): HttpClient {
            val apiClient = HttpClient(getValidationMocKEngine())
            return apiClient.config {
                expectSuccess = true

                install(ContentNegotiation) {
                    json(ktorJson)
                }
                install(Logging) {
                    logger = object : Logger {
                        override fun log(message: String) {
                            println(message)
                        }
                    }
                    level = LogLevel.ALL
                }
            }
        }
    }


    @Test
    fun `default form`() {
        controllerVersions.forEach {
            runBlocking {
                val api = LemmyApi.getLemmyApi("lemmy.ml", it)
                var resp = api.getPosts(GetPosts())
                assertDoesNotThrow("Failed for $it") { resp.getOrThrow() }
            }
        }
    }

    @Test
    fun `just page`() {
        controllerVersions.forEach {
            runBlocking {
                val api = LemmyApi.getLemmyApi("lemmy.ml", it)
                var resp = api.getPosts(GetPosts(page = 1))
                assertDoesNotThrow("Failed for $it") { resp.getOrThrow() }
            }
        }
    }


    @Test
    fun `just cursor`() {
        controllerVersions.forEach {
            runBlocking {
                val api = LemmyApi.getLemmyApi("lemmy.ml", it)
                var resp = api.getPosts(GetPosts(page_cursor = "cursor"))
                assertDoesNotThrow("Failed for $it") { resp.getOrThrow() }
            }
        }
    }

    @Test
    fun `page cursor null`() {
        controllerVersions.forEach {
            runBlocking {
                val api = LemmyApi.getLemmyApi("lemmy.ml", it)
                var resp = api.getPosts(GetPosts(page_cursor = null))
                assertDoesNotThrow("Failed for $it") { resp.getOrThrow() }
            }
        }
    }

    @Test
    fun `both page and cursor`() {
        controllerVersions.forEach {
            runBlocking {
                val api = LemmyApi.getLemmyApi("lemmy.ml", it)
                var resp = api.getPosts(GetPosts(page = 1, page_cursor = "cursor"))
                assertDoesNotThrow("Failed for $it") { resp.getOrThrow() }
            }
        }
    }

    @Test
    fun `both page and cursor null`() {
        controllerVersions.forEach {
            runBlocking {
                val api = LemmyApi.getLemmyApi("lemmy.ml", it)
                var resp = api.getPosts(GetPosts(page = 1, page_cursor = null))
                assertDoesNotThrow("Failed for $it") { resp.getOrThrow() }
            }
        }
    }

}
