import io.ktor.client.*
import io.ktor.client.engine.js.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*


actual val coreKtor : HttpClient =  HttpClient(Js) {
    expectSuccess = true
}

actual fun getKtor(baseUrl: String) = HttpClient(Js) {
    expectSuccess = true


    // set default request parameters
    defaultRequest {
        // add base url for all request
        url(baseUrl)

    }

    // use json content negotiation for serialize or deserialize
    install(ContentNegotiation) {
        json(ktorJson)
    }
}