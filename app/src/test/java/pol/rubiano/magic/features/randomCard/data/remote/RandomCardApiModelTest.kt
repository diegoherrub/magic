import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Test
import pol.rubiano.magic.features.randomCard.data.remote.ImageUris
import pol.rubiano.magic.features.randomCard.data.remote.RandomCardApiModel

class RandomCardApiModelTest {

    private val gson = Gson()

    @Test
    fun `RandomCardApiModel should serialize and deserialize correctly`() {
        val card = RandomCardApiModel(
            id = "bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd",
            name = "Black Lotus",
            manaCost = "{0}",
            typeLine = "Artifact",
            oracleText = "{T}, Sacrifice Black Lotus: Add three mana of any one color.",
            flavorText = null,
            imageUris = ImageUris(borderCrop = "https://cards.scryfall.io/border_crop/front/b/d/bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd.jpg?1614638838"),
            setName = "Vintage Masters",
            releasedAt = "2014-06-16",
            rarity = "bonus",
            artist = "Chris Rahn"
        )

        val json = gson.toJson(card) // Serialize to JSON
        val deserializedCard = gson.fromJson(json, RandomCardApiModel::class.java) // Deserialize from JSON

        assertEquals(card, deserializedCard) // Compare original and deserialized objects
    }

    @Test
    fun `ImageUris should serialize and deserialize correctly`() {
        val imageUris = ImageUris(borderCrop = "https://cards.scryfall.io/border_crop/front/b/d/bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd.jpg?1614638838")

        val json = gson.toJson(imageUris)
        val deserializedImageUris = gson.fromJson(json, ImageUris::class.java)

        assertEquals(imageUris, deserializedImageUris)
    }
}