import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import com.github.tomakehurst.wiremock.http.RequestMethod
import com.github.tomakehurst.wiremock.junit5.WireMockExtension
import com.marcinziolo.kotlin.wiremock.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import it.vercruysse.lemmyapi.LemmyApiFactory
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class AuthSetCorrectIT {

    companion object {
        @JvmField
        @RegisterExtension
        var wm = WireMockExtension.newInstance()
            .options(WireMockConfiguration.wireMockConfig().dynamicPort())
            .build()
    }

    @Test
    fun `Changing auth should propagate everywhere`() {
        val httpClient = io.ktor.client.HttpClient {
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println(message)
                    }
                }
                level = LogLevel.ALL
            }
        }
        val factory = LemmyApiFactory(httpClient)
        val controller = factory.create(instance = "${wm.baseUrl()}/lemmy.world", version = "0.19.1", auth = "auth").getOrThrow()

        // Given
        wm.get {
            url equalTo "/api/v3/site"
            headers contains HttpHeaders.Authorization equalTo "Bearer auth"
        } returnsJson {
            body = "{}"
        }

        // When
        runBlocking {
            controller.getSite()
        }

        // Then
        wm.verify {
            url equalTo "/api/v3/site"
            method = RequestMethod.GET
            headers contains HttpHeaders.Authorization equalTo "Bearer auth"
        }
        factory.close()
        httpClient.close()

        controller.auth = "newAuth"

        // Given
        wm.get {
            url equalTo "/api/v3/site"
            headers contains HttpHeaders.Authorization equalTo "Bearer newAuth"
        } returnsJson {
            body = "{}"
        }

        // When
        runBlocking {
            controller.getSite()
        }

        // Then
        wm.verify {
            url equalTo "/api/v3/site"
            headers contains HttpHeaders.Authorization equalTo "Bearer newAuth"
            method = RequestMethod.GET
        }
    }
}
