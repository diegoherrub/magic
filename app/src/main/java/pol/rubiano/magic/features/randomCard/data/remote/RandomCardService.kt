package pol.rubiano.magic.features.randomCard.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface RandomCardService {

    @GET("cards/random")
    suspend fun getRandomCard(): Response<List<RandomCardApiModel>>
}