package it.vercruysse.lemmyapi

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.http.*

/**
 * Base class for all clients that require authentication. (So all 0.19+)
 *
 * @param httpClient The HttpClient to use for requests
 * @param auth The authentication token to use for requests
 */
internal abstract class AuthBaseClient(httpClient: HttpClient, var auth: String?) {

    open val client = httpClient.config {
        defaultRequest {
            if (auth != null) {
                headers[HttpHeaders.Authorization] = "Bearer $auth"
            }
        }
    }
}
