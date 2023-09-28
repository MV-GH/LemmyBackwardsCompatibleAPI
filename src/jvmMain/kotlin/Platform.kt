import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

actual val coreKtor = HttpClient(OkHttp) {
    expectSuccess = true
}

// TODO https://ktor.io/docs/http-client-engines.html#okhttp

actual fun getKtor(baseUrl: String) = HttpClient(OkHttp) {
    // default validation to throw exceptions for non-2xx responses
    expectSuccess = true

    engine {
        // add logging interceptor
//        addInterceptor(HttpLoggingInterceptor().apply {
//            setLevel(
//                HttpLoggingInterceptor.Level.BODY
//            )
//        })
    }

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
