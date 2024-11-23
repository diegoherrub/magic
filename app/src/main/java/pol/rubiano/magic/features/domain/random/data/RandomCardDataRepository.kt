package pol.rubiano.magic.features.domain.random.data

import pol.rubiano.magic.features.domain.random.data.local.RandomCardXmlLocalDataSource
import pol.rubiano.magic.features.domain.random.data.remote.RandomCardApiRemoteDataSource
import pol.rubiano.magic.features.domain.random.data.remote.RandomCardMockRemoteDataSource
import pol.rubiano.magic.features.domain.random.domain.RandomCard
import pol.rubiano.magic.features.domain.random.domain.RandomCardRepository

class RandomCardDataRepository(
    private val localXml: RandomCardXmlLocalDataSource,
    private val remoteMock: RandomCardMockRemoteDataSource,
    private val remoteApi: RandomCardApiRemoteDataSource

): RandomCardRepository {

    override suspend fun getRandomCardFromRepository(): List<RandomCard> {
        val randomcardsFromMock = remoteMock.getMockRandomCard()
        println("randomcardsFromMock: $randomcardsFromMock")
        val randomCardsFromXml = localXml.getAllXmlRandomCards()
        if (randomCardsFromXml.isEmpty()) {
            val randomCardsFromApi = remoteApi.getApiRandomCard()
            localXml.saveAllXmlRandomCards(randomCardsFromApi)
            return randomCardsFromApi
        } else {
            return randomCardsFromXml
        }
    }
}