package pol.rubiano.magic.features.randomCard.data

import android.util.Log
import org.koin.core.annotation.Single
import pol.rubiano.magic.features.randomCard.data.local.RandomCardXmlLocalDataSource
import pol.rubiano.magic.features.randomCard.data.local.db.RandomCardDbLocalDataSource
import pol.rubiano.magic.features.randomCard.data.remote.RandomCardApiRemoteDataSource
import pol.rubiano.magic.features.randomCard.data.remote.RandomCardMockRemoteDataSource
import pol.rubiano.magic.features.randomCard.domain.RandomCard
import pol.rubiano.magic.features.randomCard.domain.RandomCardRepository

@Single
class RandomCardDataRepository(
    private val localXml: RandomCardXmlLocalDataSource,
    private val localDb: RandomCardDbLocalDataSource,
    private val remoteMock: RandomCardMockRemoteDataSource,
    private val remoteApi: RandomCardApiRemoteDataSource
) : RandomCardRepository {

    override suspend fun getRandomCardFromRepository(): Result<RandomCard> {

        Log.d("@Diego", "Fetching random card from API...")
        val randomCardFromApi = remoteApi.getApiRandomCard()
        Log.d("@Diego", "randomCardFromApi: $randomCardFromApi")
        return randomCardFromApi.onSuccess { cardFromApi ->
            Log.d("@Diego", "Successfully fetched random card from API")
            if (cardFromApi == null){
                Log.d("@Diego","Empty cards from API")

                Log.d("@Diego", "Fetching random card from DB...")
                val randomCardFromDb = localDb.getAllDbRandomCards()
                Log.d("@Diego", "Successfully fetched random card from DB")

                if (randomCardFromDb.isEmpty()) {
                    Log.d("@Diego","Empty cards from DB")

                    Log.d("@Diego", "Fetching random card from XML...")
                    val randomCardFromXml = localXml.getAllXmlRandomCards()
                    Log.d("@Diego", "Successfully fetched random card from XML")

                    if (randomCardFromXml.isEmpty()) {
                        Log.d("@Diego","Empty cards from XML")

                        Log.d("@Diego", "Fetching random card from Mock...")
                        val randomCardFromMock = remoteMock.getMockRandomCard()
                        Log.d("@Diego", "Successfully fetched random card from Mock")

                        if (randomCardFromMock == null) {
                            Log.d("@Diego","Empty cards from Mock")
                            Result.success(randomCardFromMock)
                        } else {
                            Log.d("@Diego","Cards from Mock is not empty")
                            Result.success(randomCardFromMock)
                        }

                    } else {
                        Log.d("@Diego","Cards from XML is not empty")
                        Result.success(randomCardFromXml)
                    }

                } else {
                    Log.d("@Diego","Cards from DB is not empty")
                    Result.success(randomCardFromDb)
                }

            } else {
                Log.d("@Diego","Cards from API is not empty")
                localXml.saveXmlRandomCard(cardFromApi)
                Log.d("@Diego","Saved cards from API to XML")
                localDb.insertDbRandomCard(cardFromApi)
                Log.d("@Diego","Saved cards from API to DB")
                Result.success(cardFromApi)
            }
        }
    }
}