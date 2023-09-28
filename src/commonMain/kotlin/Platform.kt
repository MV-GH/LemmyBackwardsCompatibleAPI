import io.ktor.client.*

expect fun getKtor(baseUrl: String): HttpClient

expect val coreKtor: HttpClient
