package autogenscripts

import com.charleskorn.kaml.*
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.util.cio.*
import io.ktor.utils.io.*
import kotlinx.serialization.Serializable
import java.io.File

val client = HttpClient()

@Serializable
enum class HttpMethod {
    GET,
    POST,
    PUT,
}

const val LEMMY_SPEC_LINK = """https://raw.githubusercontent.com/MV-GH/lemmy_openapi_spec/master/lemmy_spec.yaml"""

data class RouteInfo(
    val path: String,
    val method: HttpMethod,
    val paramsOrBody: String?,
    val summary: String?,
    val response: String?,
    val operationId: String?,
)

fun RouteInfo.toInterface(): String {
    return """
        /**
${summary?.lines()?.joinToString("\n") { "         * ${it.trim()}" } ?: ""}
         *
         * @${method.name}("$path")
         */
        abstract suspend fun $operationId(${if (paramsOrBody != null) "form: $paramsOrBody" else ""}): Result<${response ?: "Unit"}>
    """.replaceIndent("    ")
}

fun RouteInfo.toImpl(): String {
    return this.toInterface()
        .replace("abstract suspend fun", "override suspend fun")
        .plus(" =\n        client.${method.name.lowercase()}Result(\"$path\"${if (paramsOrBody != null) ", form" else ""})")
}

suspend fun getRoutes(): List<RouteInfo> {
    val lemmySpecFile = File("temp", "lemmy_spec.yaml")

    client.get(LEMMY_SPEC_LINK)
        .bodyAsChannel()
        .copyAndClose(lemmySpecFile.writeChannel())

    val specText = lemmySpecFile.readText()

    val result = Yaml.default.parseToYamlNode(specText)

    val routes = mutableListOf<RouteInfo>()

    val paths = (result as YamlMap).get<YamlMap>("paths")!!

    for (path in paths.entries) {
        for (method in (path.value as YamlMap).entries) {
            val route = method.value as YamlMap

            println(path.key.content)

            val summary = route.get<YamlScalar>("summary")

            val httpMethod = HttpMethod.valueOf(method.key.content.uppercase())

            val params = route.get<YamlList>("parameters")

            val responses = route.get<YamlMap>("responses")!!

            // Doesn't work for arrays of items (listLogins)
            val responseName =
                (responses.get<YamlMap>("200") ?: responses.get<YamlMap>("201"))!!
                    .get<YamlMap>("content") // Not all responses have content
                    ?.get<YamlMap>("application/json")
                    ?.get<YamlMap>("schema")
                    ?.get<YamlScalar>("\$ref")
                    ?.content?.substringAfterLast("/")

            val paramOrBodyName: String? =
                if (params != null) {
                    val param = params[0] as YamlMap
                    param.get<YamlScalar>("name")!!.content
                } else if (route.get<YamlMap>("requestBody") != null) {
                    val reqBody =
                        route
                            .get<YamlMap>("requestBody")!!
                            .get<YamlMap>("content")!!
                            .get<YamlMap>("application/json")!!
                            .get<YamlMap>("schema")!!
                            .get<YamlScalar>("\$ref")!!

                    reqBody.content.substringAfterLast("/")
                } else {
                    null
                }

            val operationId: String = route.get<YamlScalar>("operationId")?.content ?: paramOrBodyName ?: responseName?.substringBefore("Response")!!

            routes.add(
                RouteInfo(
                    path = path.key.content.substring(1), // Strip leading /
                    method = httpMethod,
                    paramsOrBody = paramOrBodyName,
                    summary = summary?.content,
                    response = responseName,
                    operationId = operationId.replaceFirstChar { it.lowercase() },
                ),
            )
        }
    }

    return routes
}

/**
 * Dumps a basic interface with routes in temp/
 *
 * This is used as a template for the actual Lemmy API interface
 */
fun genRouteAbstractInterface(routes: List<RouteInfo>) {
    val fileInterface = File("temp", "LemmyApiRouter.kt")
    fileInterface.createNewFile()

    fileInterface.writeText("\nabstract class LemmyApiRouter : LemmyApiBase {\n\n")

    for (route in routes) {
        fileInterface.appendText(route.toInterface() + "\n\n")
    }

    fileInterface.appendText("}\n")
}

/**
 * Dumps a basic implementation of the routes in temp/
 *
 * This is used as a template for the actual Lemmy API Implementation
 */
fun genRouteImpl(routes: List<RouteInfo>) {
    val fileInterface = File("temp", "LemmyApiController.kt")
    fileInterface.createNewFile()

    fileInterface.writeText("\nclass LemmyApiController(private val client: HttpClient) : LemmyApiRouter {\n\n")

    for (route in routes) {
        fileInterface.appendText(route.toImpl() + "\n\n")
    }

    fileInterface.appendText("}\n")
}

suspend fun main() {
    val routes = getRoutes()
    genRouteAbstractInterface(routes)
    println("Generated LemmyApiRouter.kt")
    genRouteImpl(routes)
    println("Generated LemmyApiController.kt")
}
