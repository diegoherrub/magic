package pol.rubiano.magic.features.randomCard.domain

import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.test.runTest
import pol.rubiano.magic.features.randomCard.data.remote.RandomCardService
import pol.rubiano.magic.features.randomCard.data.RandomCardDataRepository
import pol.rubiano.magic.features.randomCard.data.local.RandomCardXmlLocalDataSource
import pol.rubiano.magic.features.randomCard.data.local.db.RandomCardDbLocalDataSource
import pol.rubiano.magic.features.randomCard.data.remote.RandomCardApiRemoteDataSource
import pol.rubiano.magic.features.randomCard.data.remote.RandomCardMockRemoteDataSource
import retrofit2.HttpException

class RandomCardRepositoryTest : KoinTest {

    private lateinit var mockWebServer: MockWebServer
    private val randomCardRepository: RandomCardRepository by inject()

    @Before
    fun setup() {
        mockWebServer = MockWebServer()

        startKoin {
            modules(module {
                single { Gson() }
                single {
                    Retrofit.Builder()
                        .baseUrl(mockWebServer.url("/"))
                        .addConverterFactory(GsonConverterFactory.create(get()))
                        .build()
                        .create(RandomCardService::class.java)
                }
                // Bind the RandomCardRepository to its implementation
                factory<RandomCardRepository> {
                    RandomCardDataRepository(
                        localXml = get<RandomCardXmlLocalDataSource>(),
                        localDb = get<RandomCardDbLocalDataSource>(),
                        remoteMock = get<RandomCardMockRemoteDataSource>(),
                        remoteApi = get<RandomCardApiRemoteDataSource>()
                    )
                }
            })
        }
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
        stopKoin()
    }

    @Test
    fun getRandomCardFromRepository_returnsValidRandomCard() = runBlocking {

        val mockResponse = MockResponse().setResponseCode(200).setBody(VALID_CARD_JSON)
        mockWebServer.enqueue(mockResponse)

        val result = randomCardRepository.getRandomCardFromRepository()
        assert(result.isSuccess)

        val card = result.getOrNull()
        assertEquals("Black Lotus", card?.name)
        assertEquals("{0}", card?.manaCost)
        assertEquals("Artifact", card?.typeLine)
        assertEquals("{T}, Sacrifice Black Lotus: Add three mana of any one color.", card?.oracleText);
        assertEquals("https://cards.scryfall.io/border_crop/front/b/d/bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd.jpg?1614638838", card?.borderCrop?.borderCrop)
        assertEquals("Vintage Masters", card?.setName)
        assertEquals("2014-06-16", card?.releasedAt)
        assertEquals("bonus", card?.rarity)
        assertEquals("Chris Rahn", card?.artist)
    }

    @Test
    fun getRandomCardFromRepository_handlesAPIerrors() = runBlocking {
        val mockResponse = MockResponse().setResponseCode(500)
        mockWebServer.enqueue(mockResponse)
        val result = randomCardRepository.getRandomCardFromRepository()
        assert(result.isFailure)
        val exception = result.exceptionOrNull()
        assert(exception is HttpException)
        assertEquals(500, (exception as HttpException).code())
    }

    @Test
    fun getRandomCardFromRepository_handlesEmptyResponse() = runTest {
        val mockResponse = MockResponse().setResponseCode(200).setBody("")
        mockWebServer.enqueue(mockResponse)
        val result = randomCardRepository.getRandomCardFromRepository()
        assert(result.isFailure)
        assert(result.exceptionOrNull() is JsonSyntaxException)
    }

    companion object {
        private const val VALID_CARD_JSON =
            """
            {
                "id": "bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd",
                "name": "Black Lotus",
                "mana_cost": "{0}",
                "type_line": "Artifact",
                "oracle_text": "{T}, Sacrifice Black Lotus: Add three mana of any one color.",
                "image_uris": {
                    "border_crop": "https://cards.scryfall.io/border_crop/front/b/d/bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd.jpg?1614638838"
                },
                "set_name": "Vintage Masters",
                "released_at": "2014-06-16",
                "rarity": "bonus",
                "artist": "Chris Rahn"
            }
            """
    }

}
