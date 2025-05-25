package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO research delete token removal

@CommonParcelize
@Serializable
data class LocalImage(
    val local_user_id: LocalUserId? = null,
    val pictrs_alias: String,
    val pictrs_delete_token: String,
    val published: String,
) : DatatypeRoot
