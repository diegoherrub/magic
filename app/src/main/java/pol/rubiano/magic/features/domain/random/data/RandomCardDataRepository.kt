package pol.rubiano.magic.features.domain.random.data

import pol.rubiano.magic.features.domain.random.data.remote.RandomApiRemoteDataSource
import pol.rubiano.magic.features.domain.random.data.remote.RandomCardMockRemoteDataSource
import pol.rubiano.magic.features.domain.random.domain.Card
import pol.rubiano.magic.features.domain.random.domain.RandomCardRepository

class RandomCardDataRepository(
    private val remote: RandomCardMockRemoteDataSource
): RandomCardRepository {

    override fun getRandomCard(): Card {
        return remote.getMockRandomCard()
    }
}