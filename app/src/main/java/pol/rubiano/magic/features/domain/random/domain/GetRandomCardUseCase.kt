package pol.rubiano.magic.features.domain.random.domain

class GetRandomCardUseCase(
    private val randomRepository: RandomRepository
) {

    suspend operator fun invoke(): List<Card> {
        return randomRepository.getRandomCard()
    }
}