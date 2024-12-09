package pol.rubiano.magic.features.randomCard.data.remote

import retrofit2.Response
import retrofit2.http.GET

/**
 * A Retrofit service interface for fetching a random card from the API.
 */
interface RandomCardService {

    /**
     * Fetches a random card from the API.
     *
     * @return A [Response] containing a [RandomCardApiModel] object.
     */
    @GET("cards/random")
    suspend fun getRandomCard(): Response<RandomCardApiModel>
}