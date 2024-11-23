package pol.rubiano.magic.app.data.api

import pol.rubiano.magic.features.domain.random.data.remote.RandomCardService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "https://api.scryfall.com/"

    private fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideRandomCardService(): RandomCardService {
        return provideRetrofit().create(RandomCardService::class.java)
    }
}