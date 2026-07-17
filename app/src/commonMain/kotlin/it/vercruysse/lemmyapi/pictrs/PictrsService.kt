package it.vercruysse.lemmyapi.pictrs

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*
import it.vercruysse.lemmyapi.datatypes.DeleteImageParams
import it.vercruysse.lemmyapi.datatypes.UploadImageResponse
import kotlinx.serialization.Serializable

internal class PictrsService(private val client: HttpClient, var auth: String?) {

    /**
     * Upload an image to the server.
     *
     * @POST(/pictrs/image)
     */
    suspend fun uploadImage(image: ByteArray): Result<UploadImageResponse> = runCatching {
        val resp = client.post("/pictrs/image") {
            auth?.let { cookie("jwt", it) }
            setBody(createFormData(image))
        }

        val imageResp = resp.body<PictrsUploadImageResponse>()
        require(imageResp.msg == "ok") { "Pictrs upload failed: ${imageResp.msg}" }

        val file = imageResp.files.firstOrNull()
            ?: throw IllegalStateException("Pictrs upload response did not contain any files")

        UploadImageResponse(
            image_url = "${resp.call.request.url}/${file.file}",
            filename = file.file,
            // Pre-v1 delete route needs the full relative pictrs delete path.
            delete_filename = "/pictrs/image/delete/${file.delete_token}/${file.file}",
        )
    }

    /**
     * Delete an image from the server.
     *
     * @GET(/pictrs/image/delete/{delete_token}/{file})
     */
    suspend fun deleteMedia(form: DeleteImageParams): Result<Unit> = runCatching {
        require(form.filename.startsWith("/pictrs/image/delete/")) {
            "For pre-v1 Lemmy, deleteMedia filename must be /pictrs/image/delete/{delete_token}/{file}"
        }

        client.get(form.filename) {
            auth?.let { cookie("jwt", it) }
        }.body()
    }

    private fun createFormData(image: ByteArray): MultiPartFormDataContent =
        MultiPartFormDataContent(
            formData {
                append(
                    "images[]",
                    image,
                    Headers.build {
                        // Pictrs expects a file-like part with a content disposition.
                        append(HttpHeaders.ContentDisposition, "filename=\"image.jpg\"")
                    },
                )
            },
        )

    @Serializable
    private data class PictrsUploadImageResponse(
        val msg: String,
        val files: List<PictrsImageFile> = listOf(),
    )

    @Serializable
    private data class PictrsImageFile(
        val file: String,
        val delete_token: String,
    )
}
