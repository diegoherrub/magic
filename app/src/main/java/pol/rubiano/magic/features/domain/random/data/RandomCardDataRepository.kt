package pol.rubiano.magic.features.domain.random.data

import org.koin.core.annotation.Single
import pol.rubiano.magic.app.domain.ErrorApp
import pol.rubiano.magic.features.domain.random.data.local.RandomCardXmlLocalDataSource
import pol.rubiano.magic.features.domain.random.data.local.db.RandomCardDbLocalDataSource
import pol.rubiano.magic.features.domain.random.data.remote.RandomCardApiRemoteDataSource
import pol.rubiano.magic.features.domain.random.data.remote.RandomCardMockRemoteDataSource
import pol.rubiano.magic.features.domain.random.domain.RandomCard
import pol.rubiano.magic.features.domain.random.domain.RandomCardRepository

@Single
class RandomCardDataRepository(
    private val localXml: RandomCardXmlLocalDataSource,
    private val localDb: RandomCardDbLocalDataSource,
    private val remoteMock: RandomCardMockRemoteDataSource,
    private val remoteApi: RandomCardApiRemoteDataSource
) : RandomCardRepository {

    override suspend fun getRandomCardFromRepository(): Result<List<RandomCard>> {
        val randomCardFromApi = remoteApi.getApiRandomCard()
        return randomCardFromApi.onSuccess {
            localXml.saveAllXmlRandomCards(it)
            localDb.insertAllDbRandomCards(it)
        }.onFailure {
            val randomCardFromDb = localDb.getAllDbRandomCards()
            if (randomCardFromDb.isEmpty()) {
                val randomCardFromXml = localXml.getAllXmlRandomCards()
                randomCardFromXml.onSuccess {
                    Result.success(randomCardFromXml)
                }.onFailure {
                    val randomCardFromMock = remoteMock.getMockRandomCard()
                    if (randomCardFromMock.isEmpty()) {
                        Result.failure(ErrorApp.FailedGetRandomCard)
                    } else {
                        Result.success(randomCardFromMock)
                    }
                }
            } else {
                Result.success(randomCardFromDb)
            }
        }
    }
}