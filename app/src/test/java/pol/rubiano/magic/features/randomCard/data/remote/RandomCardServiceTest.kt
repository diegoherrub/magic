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

    // MockWebServer to simulate API responses
    private lateinit var mockWebServer: MockWebServer

    // Inject RandomCardService
    private val randomCardService: RandomCardService by inject()

    @Before
    fun setup() {

        // Initialize MockWebServer
        mockWebServer = MockWebServer()

        // Start Koin with test modules
        startKoin {
            modules(module {
                single { Gson() } // Provide Gson instance
                single { // Provide a Retrofit instance for MockWebServer
                    Retrofit.Builder()
                        .baseUrl(mockWebServer.url("/"))
                        .addConverterFactory(GsonConverterFactory.create(get()))
                        .build()
                        .create(RandomCardService::class.java)
                } // Provide RandomCardService instance
            })
        }
    }

    @After
    fun tearDown() {
        // Shut down MockWebServer and stop Koin
        mockWebServer.shutdown()
        stopKoin()
    }

    @Test
    fun `getRandomCard returns successful response`() = runBlocking {
        val mockResponse = MockResponse().setResponseCode(200).setBody(
                """
                {
                    "object": "card",
                    "id": "bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd",
                    "oracle_id": "5089ec1a-f881-4d55-af14-5d996171203b",
                    "multiverse_ids": [
                        382866
                    ],
                    "mtgo_id": 53155,
                    "mtgo_foil_id": 53156,
                    "name": "Black Lotus",
                    "lang": "en",
                    "released_at": "2014-06-16",
                    "uri": "https://api.scryfall.com/cards/bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd",
                    "scryfall_uri": "https://scryfall.com/card/vma/4/black-lotus?utm_source=api",
                    "layout": "normal",
                    "highres_image": true,
                    "image_status": "highres_scan",
                    "image_uris": {
                        "small": "https://cards.scryfall.io/small/front/b/d/bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd.jpg?1614638838",
                        "normal": "https://cards.scryfall.io/normal/front/b/d/bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd.jpg?1614638838",
                        "large": "https://cards.scryfall.io/large/front/b/d/bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd.jpg?1614638838",
                        "png": "https://cards.scryfall.io/png/front/b/d/bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd.png?1614638838",
                        "art_crop": "https://cards.scryfall.io/art_crop/front/b/d/bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd.jpg?1614638838",
                        "border_crop": "https://cards.scryfall.io/border_crop/front/b/d/bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd.jpg?1614638838"
                    },
                    "mana_cost": "{0}",
                    "cmc": 0.0,
                    "type_line": "Artifact",
                    "oracle_text": "{T}, Sacrifice Black Lotus: Add three mana of any one color.",
                    "colors": [],
                    "color_identity": [],
                    "keywords": [],
                    "produced_mana": [
                        "B",
                        "G",
                        "R",
                        "U",
                        "W"
                    ],
                    "legalities": {
                        "standard": "not_legal",
                        "future": "not_legal",
                        "historic": "not_legal",
                        "timeless": "not_legal",
                        "gladiator": "not_legal",
                        "pioneer": "not_legal",
                        "explorer": "not_legal",
                        "modern": "not_legal",
                        "legacy": "banned",
                        "pauper": "not_legal",
                        "vintage": "restricted",
                        "penny": "not_legal",
                        "commander": "banned",
                        "oathbreaker": "banned",
                        "standardbrawl": "not_legal",
                        "brawl": "not_legal",
                        "alchemy": "not_legal",
                        "paupercommander": "not_legal",
                        "duel": "banned",
                        "oldschool": "not_legal",
                        "premodern": "not_legal",
                        "predh": "banned"
                    },
                    "games": [
                        "mtgo"
                    ],
                    "reserved": true,
                    "foil": true,
                    "nonfoil": true,
                    "finishes": [
                        "nonfoil",
                        "foil"
                    ],
                    "oversized": false,
                    "promo": false,
                    "reprint": true,
                    "variation": false,
                    "set_id": "a944551a-73fa-41cd-9159-e8d0e4674403",
                    "set": "vma",
                    "set_name": "Vintage Masters",
                    "set_type": "masters",
                    "set_uri": "https://api.scryfall.com/sets/a944551a-73fa-41cd-9159-e8d0e4674403",
                    "set_search_uri": "https://api.scryfall.com/cards/search?order=set&q=e%3Avma&unique=prints",
                    "scryfall_set_uri": "https://scryfall.com/sets/vma?utm_source=api",
                    "rulings_uri": "https://api.scryfall.com/cards/bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd/rulings",
                    "prints_search_uri": "https://api.scryfall.com/cards/search?order=released&q=oracleid%3A5089ec1a-f881-4d55-af14-5d996171203b&unique=prints",
                    "collector_number": "4",
                    "digital": true,
                    "rarity": "bonus",
                    "card_back_id": "0aeebaf5-8c7d-4636-9e82-8c27447861f7",
                    "artist": "Chris Rahn",
                    "artist_ids": [
                        "7742047e-0f80-4c0f-a530-d07460165e86"
                    ],
                    "illustration_id": "da62ded1-bedd-44c6-8950-ca56e691a899",
                    "border_color": "black",
                    "frame": "2015",
                    "security_stamp": "oval",
                    "full_art": false,
                    "textless": false,
                    "booster": true,
                    "story_spotlight": false,
                    "prices": {
                        "usd": null,
                        "usd_foil": null,
                        "usd_etched": null,
                        "eur": null,
                        "eur_foil": null,
                        "tix": "48.99"
                    },
                    "related_uris": {
                        "gatherer": "https://gatherer.wizards.com/Pages/Card/Details.aspx?multiverseid=382866&printed=false",
                        "tcgplayer_infinite_articles": "https://tcgplayer.pxf.io/c/4931599/1830156/21018?subId1=api&trafcat=infinite&u=https%3A%2F%2Finfinite.tcgplayer.com%2Fsearch%3FcontentMode%3Darticle%26game%3Dmagic%26partner%3Dscryfall%26q%3DBlack%2BLotus",
                        "tcgplayer_infinite_decks": "https://tcgplayer.pxf.io/c/4931599/1830156/21018?subId1=api&trafcat=infinite&u=https%3A%2F%2Finfinite.tcgplayer.com%2Fsearch%3FcontentMode%3Ddeck%26game%3Dmagic%26partner%3Dscryfall%26q%3DBlack%2BLotus",
                        "edhrec": "https://edhrec.com/route/?cc=Black+Lotus"
                    },
                    "purchase_uris": {
                        "tcgplayer": "https://tcgplayer.pxf.io/c/4931599/1830156/21018?subId1=api&u=https%3A%2F%2Fwww.tcgplayer.com%2Fsearch%2Fmagic%2Fproduct%3FproductLineName%3Dmagic%26q%3DBlack%2BLotus%26view%3Dgrid",
                        "cardmarket": "https://www.cardmarket.com/en/Magic/Products/Search?referrer=scryfall&searchString=Black+Lotus&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                        "cardhoarder": "https://www.cardhoarder.com/cards/53155?affiliate_id=scryfall&ref=card-profile&utm_campaign=affiliate&utm_medium=card&utm_source=scryfall"
                    }
                }
                """
            )
        mockWebServer.enqueue(mockResponse)

        val response = randomCardService.getRandomCard()

        // test only fields for RandomCard
        assertEquals(200, response.code())
        assertEquals("bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd", response.body()?.id)
        assertEquals("Black Lotus", response.body()?.name)
        assertEquals("{0}", response.body()?.manaCost)
        assertEquals("Artifact", response.body()?.typeLine)
        assertEquals("{T}, Sacrifice Black Lotus: Add three mana of any one color.", response.body()?.oracleText)
        assertEquals(null, response.body()?.flavorText)
        val imageUris = response.body()?.imageUris
        assertEquals(
            "https://cards.scryfall.io/border_crop/front/b/d/bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd.jpg?1614638838",
            imageUris?.borderCrop)
        assertEquals("Vintage Masters", response.body()?.setName)
        assertEquals("2014-06-16", response.body()?.releasedAt)
        assertEquals("bonus", response.body()?.rarity)
        assertEquals("Chris Rahn", response.body()?.artist)
    }
}