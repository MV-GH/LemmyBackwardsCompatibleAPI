package pictrs

import pictrs.datatypes.DeleteImage
import pictrs.datatypes.UploadImage
import pictrs.datatypes.UploadImageResponse

interface PictrsAPI {
    var auth: String?

    /**
     * Upload an image to the server.
     *
     * @POST(/pictrs/image)
     */
    suspend fun uploadImage(form: UploadImage): Result<UploadImageResponse>

    /**
     * Delete an image from the server.
     *
     * @POST(/pictrs/image/delete)
     */
    suspend fun deleteImage(form: DeleteImage) = deleteImage("/pictrs/image/delete/${form.delete_token}/${form.filename}")

    /**
     * Delete an image from the server.
     *
     * @POST(/pictrs/image/delete)
     */
    suspend fun deleteImage(relativeUrl: String): Result<Unit>
}
