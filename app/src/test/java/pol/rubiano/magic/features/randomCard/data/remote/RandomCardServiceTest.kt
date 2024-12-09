package pol.rubiano.magic.features.randomCard.data.remote

import com.google.gson.Gson
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

class RandomCardServiceTest : KoinTest {

    private lateinit var mockWebServer: MockWebServer
    private val randomCardService: RandomCardService by inject() // Inject RandomCardService
    private val gson: Gson by inject() // Inject Gson

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        // Start Koin with test modules
        startKoin {
            modules(
                module {
                    single { Gson() } // Provide Gson instance
                    single {
                        Retrofit.Builder()
                            .baseUrl(mockWebServer.url("/"))
                            .addConverterFactory(GsonConverterFactory.create(get()))
                            .build()
                            .create(RandomCardService::class.java)
                    } // Provide RandomCardService instance
                }
            )
        }
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
        stopKoin() // Stop Koin after test
    }

    @Test
    fun `getRandomCard returns successful response`() = runBlocking {
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(
                """
                {
                  "name": "Test Card",
                  "type": "Creature"
                }
                """
            )
        mockWebServer.enqueue(mockResponse)

        val response = randomCardService.getRandomCard()

        assertEquals(200, response.code())
        assertEquals("Test Card", response.body()?.name)
    }
}