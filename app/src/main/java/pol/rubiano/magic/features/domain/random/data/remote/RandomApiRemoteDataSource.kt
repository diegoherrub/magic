package pol.rubiano.magic.features.domain.random.data.remote

import pol.rubiano.magic.features.domain.random.domain.Card

class RandomApiRemoteDataSource(
    private val randomCardService: RandomCardService
) {

    suspend fun getRandomCard(): List<Card> {
        val response = randomCardService.requestRandomCard()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            return emptyList()
        }
    }
}