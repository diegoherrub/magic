package pol.rubiano.magic.features.domain.random.data

import android.util.Log
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

        Log.d("@dev", "Fetching random card from API...")
        val randomCardFromApi = remoteApi.getApiRandomCard()

        return randomCardFromApi.onSuccess { cardsFromApi ->
            Log.d("@dev", "Successfully fetched random card from API")
            if (cardsFromApi.isEmpty()){
                Log.d("@dev","Empty cards from API")

                Log.d("@dev", "Fetching random card from DB...")
                val randomCardFromDb = localDb.getAllDbRandomCards()
                Log.d("@dev", "Successfully fetched random card from DB")

                if (randomCardFromDb.isEmpty()) {
                    Log.d("@dev","Empty cards from DB")

                    Log.d("@dev", "Fetching random card from XML...")
                    val randomCardFromXml = localXml.getAllXmlRandomCards()
                    Log.d("@dev", "Successfully fetched random card from XML")

                    if (randomCardFromXml.isEmpty()) {
                        Log.d("@dev","Empty cards from XML")

                        Log.d("@dev", "Fetching random card from Mock...")
                        val randomCardFromMock = remoteMock.getMockRandomCard()
                        Log.d("@dev", "Successfully fetched random card from Mock")

                        if (randomCardFromMock.isEmpty()) {
                            Log.d("@dev","Empty cards from Mock")
                            Result.success(randomCardFromMock)
                        } else {
                            Log.d("@dev","Cards from Mock is not empty")
                            Result.success(randomCardFromMock)
                        }

                    } else {
                        Log.d("@dev","Cards from XML is not empty")
                        Result.success(randomCardFromXml)
                    }

                } else {
                    Log.d("@dev","Cards from DB is not empty")
                    Result.success(randomCardFromDb)
                }

            } else {
                Log.d("@dev","Cards from API is not empty")
                localXml.saveAllXmlRandomCards(cardsFromApi)
                Log.d("@dev","Saved cards from API to XML")
                localDb.insertAllDbRandomCards(cardsFromApi)
                Log.d("@dev","Saved cards from API to DB")
                Result.success(cardsFromApi)
            }
        }
    }
}