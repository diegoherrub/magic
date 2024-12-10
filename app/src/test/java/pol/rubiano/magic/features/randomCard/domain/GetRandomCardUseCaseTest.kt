/*
package pol.rubiano.magic.features.randomCard.domain

import androidx.test.core.app.ApplicationProvider
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import okhttp3.Response
import org.junit.Before
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import pol.rubiano.magic.features.randomCard.data.RandomCardDataRepository
import pol.rubiano.magic.features.randomCard.data.local.RandomCardXmlLocalDataSource
import pol.rubiano.magic.features.randomCard.data.local.db.RandomCardDao
import pol.rubiano.magic.features.randomCard.data.local.db.RandomCardDbLocalDataSource
import pol.rubiano.magic.features.randomCard.data.local.db.RandomCardEntity
import pol.rubiano.magic.features.randomCard.data.remote.RandomCardApiModel
import pol.rubiano.magic.features.randomCard.data.remote.RandomCardApiRemoteDataSource
import pol.rubiano.magic.features.randomCard.data.remote.RandomCardMockRemoteDataSource
import pol.rubiano.magic.features.randomCard.data.remote.RandomCardService
import kotlin.test.assertEquals

class GetRandomCardUseCaseTest : KoinTest {

    private val getRandomCardUseCase: GetRandomCardUseCase by inject()
    private lateinit var randomCardRepository: RandomCardRepository

    @Before
    fun setup() {
        startKoin {
            androidContext(ApplicationProvider.getApplicationContext())
            modules(module {
                factory<RandomCardRepository> {
                    RandomCardDataRepository(
                        remoteApi = get<RandomCardApiRemoteDataSource>(),
                        remoteMock = get<RandomCardMockRemoteDataSource>(),
                        localDb = get<RandomCardDbLocalDataSource>(),
                        localXml = get<RandomCardXmlLocalDataSource>()
                    )
                }
                factory { GetRandomCardUseCase(get()) }
                factory<RandomCardApiRemoteDataSource> {
                    RandomCardApiRemoteDataSource(randomCardService = get())
                }
                factory<RandomCardMockRemoteDataSource> {
                    RandomCardMockRemoteDataSource()
                }
                factory<RandomCardDbLocalDataSource> {
                    RandomCardDbLocalDataSource(randomCardDao = FakeRandomCardDao())
                }
                factory<RandomCardXmlLocalDataSource> {
                    RandomCardXmlLocalDataSource(context = androidContext())
                }
                factory<RandomCardService> { FakeRandomCardService() }
            })
        }
        randomCardRepository = RandomCardDataRepository(
            remoteApi = RandomCardApiRemoteDataSource(FakeRandomCardService()),
            remoteMock = RandomCardMockRemoteDataSource(),
            localDb = RandomCardDbLocalDataSource(FakeRandomCardDao()),
            localXml = RandomCardXmlLocalDataSource(context = ApplicationProvider.getApplicationContext())
        )
    }

    // ... (rest of the code remains the same) ...

    @Test
    fun `invokeShouldReturnSuccessResult_whenRepositoryReturnsSuccess`() = runTest {
        // Arrange
        val imageUris = ImageUris(borderCrop = "test_image_url")
        val randomCard = RandomCard(
            id = "test_id",
            name = "Test Card",
            manaCost = "{1}{R}",
            typeLine = "Creature — Goblin",
            oracleText = "Haste",
            flavorText = null,
            borderCrop = imageUris,
            setName = "Test Set",
            releasedAt = "2023-10-27",
            rarity = "common",
            artist = "Test Artist"
        )

        // Act
        val result = getRandomCardUseCase()

        // Assert
        assertTrue(result.isSuccess)
        assertEquals(randomCard, result.getOrNull())
    }

    // ... (other test functions remain the same) ...
}

// Fake implementations for RandomCardDao and RandomCardService
class FakeRandomCardDao : RandomCardDao {
    // Implement the methods of RandomCardDao with fake behavior
    // For example:
    override suspend fun getRandomCard(): RandomCard? {
        val imageUris = ImageUris(borderCrop = "test_image_url")
        return RandomCard(
            id = "test_id",
            name = "Test Card",
            manaCost = "{1}{R}",
            typeLine = "Creature — Goblin",
            oracleText = "Haste",
            flavorText = null,
            borderCrop = imageUris,
            setName = "Test Set",
            releasedAt = "2023-10-27",
            rarity = "common",
            artist = "Test Artist"
        )
    }

    override suspend fun insert(randomCard: RandomCardEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun insertAll(vararg randomCars: RandomCardEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun selectAll(): List<RandomCardEntity> {
        TODO("Not yet implemented")
    }
}

class FakeRandomCardService : RandomCardService {
    // Implement the methods of RandomCardService with fake behavior
    // For example:
    override suspend fun getRandomCard(): retrofit2.Response<RandomCardApiModel> {
        val imageUris = ImageUris(borderCrop = "test_image_url")
        return RandomCard(
            id = "test_id",
            name = "Test Card",
            manaCost = "{1}{R}",
            typeLine = "Creature — Goblin",
            oracleText = "Haste",
            flavorText = null,
            borderCrop = imageUris,
            setName = "Test Set",
            releasedAt = "2023-10-27",
            rarity = "common",
            artist = "Test Artist"
        )
    }
}*/
