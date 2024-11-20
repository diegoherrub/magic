package pol.rubiano.magic.features.domain.random.domain

interface RandomRepository {

    suspend fun getRandomCard(): List<Card>
}