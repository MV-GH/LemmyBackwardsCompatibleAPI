import io.ktor.client.*
import pictrs.PictrsService

// Wanted to keep this as a interface, but interfaces can't keep state
abstract class LemmyApiBase(
    val httpClient: HttpClient,
    val version: String,
    override var auth: String?,
) : PictrsService(httpClient, version, auth), OldRoutes {
    @Suppress("PropertyName")
    val FF = FeatureFlags(version)
}

// TODO: nodeinfo
