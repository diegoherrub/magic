package pol.rubiano.magic.features.domain.random.data.remote

import pol.rubiano.magic.features.domain.random.domain.RandomCard

class RandomCardApiRemoteDataSource(
    private val randomCardService: RandomCardService
) {

    suspend fun getApiRandomCard(): List<RandomCard> {
        val response = randomCardService.getRandomCard()
        return if (response.isSuccessful) {
            response.body()!!.map {
                it.toModel()
            }
        } else {
            emptyList()
        }
    }
}