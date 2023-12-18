package it.vercruysse.lemmyapi.pictrs

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*
import it.vercruysse.lemmyapi.pictrs.datatypes.UploadImage
import it.vercruysse.lemmyapi.pictrs.datatypes.UploadImageResponse

open class PictrsService(private val ktor: HttpClient, override var auth: String?) : PictrsAPI {
    /**
     * Upload an image to the server.
     *
     * @POST(/pictrs/image)
     */
    override suspend fun uploadImage(form: UploadImage): Result<UploadImageResponse> {
        return runCatching {
            val resp =
                ktor.post("/pictrs/image") {
                    auth?.let { cookie("jwt", it) }
                    setBody(
                        MultiPartFormDataContent(
                            formData {
                                for (image in form.images) {
                                    append(
                                        "images[]",
                                        image,
                                        Headers.build {
                                            // This is somehow needed, but it doesn't matter what you send
                                            append(HttpHeaders.ContentDisposition, "filename=\"test.jpg\"")
                                        },
                                    )
                                }
                            },
                        ),
                    )
                }

            val imageResp = resp.body<UploadImageResponse>()

            imageResp.copy(
                files =
                    imageResp.files.map {
                        it.copy(
                            url = "${resp.call.request.url}/${it.file}",
                            delete_url = "${resp.call.request.url}/delete/${it.delete_token}/${it.file}",
                        )
                    },
            )
        }
    }

    /**
     * Delete an image from the server.
     *
     * @POST(/pictrs/image/delete)
     */
    override suspend fun deleteImage(relativeUrl: String): Result<Unit> {
        return runCatching {
            ktor.get(relativeUrl) {
                auth?.let { cookie("jwt", it) }
            }.body()
        }
    }
}
