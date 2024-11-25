package pol.rubiano.magic.features.randomCard.data.remote


import org.koin.core.annotation.Single
import pol.rubiano.magic.app.data.remote.apiCall
import pol.rubiano.magic.features.randomCard.domain.RandomCard

@Single
class RandomCardApiRemoteDataSource(
    private val randomCardService: RandomCardService
) {
    suspend fun getApiRandomCard(): Result<List<RandomCard>> {
        return apiCall {
            randomCardService.getRandomCard()
        }.map {
            it.map {
                it.toModel()
            }
        }
    }
}