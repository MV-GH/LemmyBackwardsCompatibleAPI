import io.ktor.client.*
import io.ktor.client.engine.js.*

actual val baseClient = HttpClient(Js)
