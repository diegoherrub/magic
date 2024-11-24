package pol.rubiano.magic.features.randomCard.domain.random.domain

interface RandomCardRepository {

    suspend fun getRandomCardFromRepository(): Result<List<RandomCard>>
}