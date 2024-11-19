package pol.rubiano.magic.features.domain.random.domain

class GetRandomUseCase(
    private val randomRepository: RandomRepository
) {

    operator fun invoke(): Card {
        return randomRepository.getRandomCard()
    }
}