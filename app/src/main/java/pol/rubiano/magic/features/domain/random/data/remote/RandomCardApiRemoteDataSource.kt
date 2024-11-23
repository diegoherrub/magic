package pol.rubiano.magic.features.domain.random.data.remote

import org.koin.core.annotation.Single
import pol.rubiano.magic.app.data.remote.apiCall
import pol.rubiano.magic.app.domain.ErrorApp
import pol.rubiano.magic.features.domain.random.domain.RandomCard

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