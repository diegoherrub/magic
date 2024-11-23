package pol.rubiano.magic.features.domain.random.domain

interface RandomCardRepository {

    suspend fun getRandomCardFromRepository(): Result<List<RandomCard>>
}