package pol.rubiano.magic.features.domain.random.data

import pol.rubiano.magic.features.domain.random.data.remote.RandomApiRemoteDataSource
import pol.rubiano.magic.features.domain.random.domain.Card
import pol.rubiano.magic.features.domain.random.domain.RandomRepository

class RandomDataRepository(
    private val remote: RandomApiRemoteDataSource
): RandomRepository {

    override suspend fun getRandomCard(): List<Card> {
        return remote.getRandomCard()
    }
}