package pol.rubiano.magic.features.domain.random.data.remote

import com.google.gson.annotations.SerializedName
import pol.rubiano.magic.features.domain.random.domain.Card
import pol.rubiano.magic.features.domain.random.domain.ImageUris

class RandomCardMockRemoteDataSource {

    fun randomCard(): Card {

        val mockUris = ImageUris(
            artCrop = "https://c1.scryfall.com/file/scryfall-cards/art_crop/front/6/e/6ec7fa5b-d0f4-497e-8d73-72b0ff3799b6.jpg"
        )

        return Card(
            "6ec7fa5b-d0f4-497e-8d73-72b0ff3799b6",
            "Lightning Bolt",
            "{R}",
            "Instant",
            "Lightning Bolt deals 3 damage to any target.",
            "Rage is a fuel that takes us further than we thought possible.",
            mockUris,
            "Limited Edition Alpha",
            "1993-08-05",
            "common",
            "Christopher Rush"
        )
    }

    fun getMockRandomCard(): Card {
        return randomCard()
    }
}