import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respondError
import io.ktor.http.HttpStatusCode
import it.vercruysse.lemmyapi.LemmyApiBaseController
import it.vercruysse.lemmyapi.LemmyApiClient
import it.vercruysse.lemmyapi.LemmyAuth
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.LemmyVersion
import it.vercruysse.lemmyapi.datatypes.GetModlog
import it.vercruysse.lemmyapi.datatypes.HidePosts
import it.vercruysse.lemmyapi.datatypes.ListPersonHidden
import it.vercruysse.lemmyapi.datatypes.ListPersonLiked
import it.vercruysse.lemmyapi.datatypes.ListPersonRead
import it.vercruysse.lemmyapi.datatypes.UserBlockInstanceCommunitiesParams
import it.vercruysse.lemmyapi.datatypes.UserBlockInstancePersonsParams
import it.vercruysse.lemmyapi.exception.NotSupportedException
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class FeatureFlagsConsistencyTest {
    private val versions = listOf("0.18.5", "0.19.0", "0.19.3", "0.19.4", "0.19.6", "0.19.11", "1.0.0")

    private val checks: List<Triple<String, (LemmyApiBaseController) -> Boolean, suspend LemmyApiBaseController.() -> Result<*>>> = listOf(
        Triple("instanceBlock", { it.FF.instanceBlock() }, { userBlockInstanceCommunities(UserBlockInstanceCommunitiesParams(1, true)) }),
        Triple("instanceBlockPersons", { it.FF.instanceBlockPersons() }, { userBlockInstancePersons(UserBlockInstancePersonsParams(1, true)) }),
        Triple("hidePost", { it.FF.hidePost() }, { hidePosts(HidePosts(listOf(1), true)) }),
        Triple("modlog", { it.FF.modlog() }, { getModlog(GetModlog()) }),
        Triple("listPersonRead", { it.FF.listPersonReadHiddenLiked() }, { listPersonRead(ListPersonRead()) }),
        Triple("listPersonHidden", { it.FF.listPersonReadHiddenLiked() }, { listPersonHidden(ListPersonHidden()) }),
        Triple("listPersonLiked", { it.FF.listPersonReadHiddenLiked() }, { listPersonLiked(ListPersonLiked()) }),
    )

    @Test
    fun `feature flags match the endpoints each version supports`() = runBlocking {
        val client = HttpClient(MockEngine { respondError(HttpStatusCode.BadRequest) })
        val apiClient = LemmyApiClient(client)
        try {
            for (version in versions) {
                val api = apiClient.connectForVersion(LemmyInstance("lemmy.ml"), LemmyAuth.Bearer("token"), LemmyVersion(version)).getOrThrow()
                for ((name, flag, call) in checks) {
                    val supported = api.call().exceptionOrNull() !is NotSupportedException
                    assertEquals(flag(api), supported, "$name on $version")
                }
            }
        } finally {
            apiClient.close()
            client.close()
        }
    }
}
