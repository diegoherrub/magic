package pol.rubiano.magic.features.domain.random.data.remote

import pol.rubiano.magic.features.domain.random.domain.Card
import retrofit2.Response
import retrofit2.http.GET

interface RandomCardService {

    @GET("cards/random")
    suspend fun requestRandomCard(): Response<List<Card>>
}