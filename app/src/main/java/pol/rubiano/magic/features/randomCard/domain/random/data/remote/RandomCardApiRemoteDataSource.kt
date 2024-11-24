package pol.rubiano.magic.features.randomCard.domain.random.data.remote

import org.koin.core.annotation.Single
import pol.rubiano.magic.app.data.remote.apiCall
import pol.rubiano.magic.features.randomCard.domain.random.domain.RandomCard

@Single
class RandomCardApiRemoteDataSource(
    private val randomCardService: RandomCardService
) {

    suspend fun getApiRandomCard(): Result<List<RandomCard>> {
        return apiCall {
            randomCardService.getRandomCard()
        }.map { randomCards ->
            randomCards.map { randomCard ->
                randomCard.toModel()
            }
        }
    }
}