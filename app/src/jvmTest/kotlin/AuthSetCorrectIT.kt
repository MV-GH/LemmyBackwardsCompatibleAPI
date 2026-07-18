import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import com.github.tomakehurst.wiremock.http.RequestMethod
import com.github.tomakehurst.wiremock.junit5.WireMockExtension
import com.marcinziolo.kotlin.wiremock.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import it.vercruysse.lemmyapi.LemmyApiClient
import it.vercruysse.lemmyapi.LemmyAuth
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.LemmyVersion
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
        val factory = LemmyApiClient(httpClient)
        val controller = factory.connectForVersion(
            LemmyInstance("${wm.baseUrl()}/lemmy.world"),
            LemmyVersion("0.19.1"),
            LemmyAuth.Bearer("auth"),
        ).getOrThrow()

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

        controller.updateAuth(LemmyAuth.Bearer("newAuth"))

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

        controller.clearAuth()
        wm.get {
            url equalTo "/api/v3/site"
        } returnsJson {
            body = "{}"
        }

        runBlocking {
            controller.getSite()
        }

        wm.verify(
            getRequestedFor(urlEqualTo("/api/v3/site"))
                .withoutHeader(HttpHeaders.Authorization),
        )

        factory.close()
        httpClient.close()
    }
}
