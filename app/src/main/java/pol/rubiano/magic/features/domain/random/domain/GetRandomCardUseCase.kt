package pol.rubiano.magic.features.domain.random.domain

class GetRandomCardUseCase(
    private val randomCardRepository: RandomCardRepository
) {

    operator fun invoke(): Card {
        return randomCardRepository.getRandomCard()
    }
}