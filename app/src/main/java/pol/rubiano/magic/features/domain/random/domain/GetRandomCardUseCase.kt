package pol.rubiano.magic.features.domain.random.domain

class GetRandomCardUseCase(
    private val randomCardRepository: RandomCardRepository
) {

    suspend operator fun invoke(): List<RandomCard> {
        return randomCardRepository.getRandomCardFromRepository()
    }
}