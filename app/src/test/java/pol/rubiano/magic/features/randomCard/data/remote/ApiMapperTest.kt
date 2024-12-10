package pol.rubiano.magic.features.randomCard.data.remote

import org.junit.Assert.assertEquals
import org.junit.Test
import pol.rubiano.magic.features.randomCard.domain.RandomCard

class ApiMapperTest {

    @Test
    fun `RandomCardApiModel should map correctly to RandomCard`() {
        val imageUrisApiModel =
            pol.rubiano.magic.features.randomCard.data.remote.ImageUris(borderCrop = "https://cards.scryfall.io/border_crop/front/b/d/bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd.jpg?1614638838")
        val randomCardApiModel = RandomCardApiModel(
            id = "bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd",
            name = "Black Lotus",
            manaCost = "{0}",
            typeLine = "Artifact",
            oracleText = "{T}, Sacrifice Black Lotus: Add three mana of any one color.",
            flavorText = null,
            imageUris = imageUrisApiModel,
            setName = "Vintage Masters",
            releasedAt = "2014-06-16",
            rarity = "bonus",
            artist = "Chris Rahn"
        )

        val expectedImageUris =
            pol.rubiano.magic.features.randomCard.domain.ImageUris(borderCrop = "https://cards.scryfall.io/border_crop/front/b/d/bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd.jpg?1614638838")
        val expectedRandomCard = RandomCard(
            id = "bd8fa327-dd41-4737-8f19-2cf5eb1f7cdd",
            name = "Black Lotus",
            manaCost = "{0}",
            typeLine = "Artifact",
            oracleText = "{T}, Sacrifice Black Lotus: Add three mana of any one color.",
            flavorText = null,
            borderCrop = expectedImageUris,
            setName = "Vintage Masters",
            releasedAt = "2014-06-16",
            rarity = "bonus",
            artist = "Chris Rahn"
        )

        // Call toModel()
        val actualRandomCard = randomCardApiModel.toModel()

        assertEquals(expectedRandomCard.id, actualRandomCard.id)
        assertEquals(expectedRandomCard.name, actualRandomCard.name)
        assertEquals(expectedRandomCard.manaCost, actualRandomCard.manaCost)
        assertEquals(expectedRandomCard.typeLine, actualRandomCard.typeLine)
        assertEquals(expectedRandomCard.oracleText, actualRandomCard.oracleText)
        assertEquals(expectedRandomCard.flavorText, actualRandomCard.flavorText)
        assertEquals(
            expectedRandomCard.borderCrop.borderCrop, actualRandomCard.borderCrop.borderCrop
        )
        assertEquals(expectedRandomCard.setName, actualRandomCard.setName)
        assertEquals(expectedRandomCard.releasedAt, actualRandomCard.releasedAt)
        assertEquals(expectedRandomCard.rarity, actualRandomCard.rarity)
        assertEquals(expectedRandomCard.artist, actualRandomCard.artist)
    }
}