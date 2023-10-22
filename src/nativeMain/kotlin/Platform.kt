import io.ktor.client.*
import io.ktor.client.engine.curl.*

actual val baseClient = HttpClient(Curl)
