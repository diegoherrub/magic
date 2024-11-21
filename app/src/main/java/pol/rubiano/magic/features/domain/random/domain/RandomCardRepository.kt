package pol.rubiano.magic.features.domain.random.domain

interface RandomCardRepository {

    fun getRandomCard(): Card
}