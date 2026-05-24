package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class UploadImageResponse(
    val image_url: String,
    val filename: String,
    /* Added for pre V1 compatability, deletion requires a combination of filename and secret.
     Pass this to delete endpoint */
    val delete_filename: String = filename,
) : DatatypeRoot
