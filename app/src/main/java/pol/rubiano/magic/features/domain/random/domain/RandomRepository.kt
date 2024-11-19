package pol.rubiano.magic.features.domain.random.domain

interface RandomRepository {

    /**
     * Get a random card from the repository
     */
    fun getRandomCard(): Card
}