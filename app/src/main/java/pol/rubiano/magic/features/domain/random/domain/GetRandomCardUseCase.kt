package pol.rubiano.magic.features.domain.random.domain

import org.koin.core.annotation.Single
import pol.rubiano.magic.app.domain.ErrorApp

@Single
class GetRandomCardUseCase(
    private val randomCardRepository: RandomCardRepository
) {

    suspend operator fun invoke(): Result<List<RandomCard>> {
        val randomCard = randomCardRepository.getRandomCardFromRepository()
        return randomCard.fold(
            onSuccess = {
                Result.success(it)
            },
            onFailure = {
                Result.failure(ErrorApp.ServerErrorApp)
            }
        )
    }
}