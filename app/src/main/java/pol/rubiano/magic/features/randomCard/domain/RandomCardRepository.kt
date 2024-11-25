package pol.rubiano.magic.features.randomCard.domain

interface RandomCardRepository {

    suspend fun getRandomCardFromRepository(): Result<List<RandomCard>>
}