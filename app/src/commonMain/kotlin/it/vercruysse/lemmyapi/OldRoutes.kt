package it.vercruysse.lemmyapi

import it.vercruysse.lemmyapi.datatypes.PagedResponse
import it.vercruysse.lemmyapi.datatypes.PersonView

/**
 * This file is for routes that are no longer used by the latest version of Lemmy.
 * But need to be kept for backwards compatibility.
 */
interface OldRoutes {

    /**
     * Get a list of banned users
     *
     * @GET("user/banned")
     */
    suspend fun getBannedPersons(): Result<PagedResponse<PersonView>>
}
