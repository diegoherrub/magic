package pol.rubiano.magic.features.randomCard.domain

import org.koin.core.annotation.Single
import pol.rubiano.magic.app.domain.ErrorApp

@Single
class GetRandomCardUseCase(
    private val randomCardRepository: RandomCardRepository
) {

    suspend operator fun invoke(): Result<RandomCard> {
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