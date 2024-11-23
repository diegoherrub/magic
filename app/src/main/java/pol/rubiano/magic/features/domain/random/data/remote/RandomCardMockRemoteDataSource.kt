package pol.rubiano.magic.features.domain.random.data.remote

import pol.rubiano.magic.features.domain.random.domain.RandomCard
import pol.rubiano.magic.features.domain.random.domain.ImageUris

class RandomCardMockRemoteDataSource {

    fun getMockRandomCard(): List<RandomCard> {

        val mockUrisCard1 = ImageUris(
            artCrop = "https://c1.scryfall.com/file/scryfall-cards/art_crop/front/6/e/6ec7fa5b-d0f4-497e-8d73-72b0ff3799b6.jpg"
        )

        val mockUrisCard2 = ImageUris(
            artCrop = "https://c1.scryfall.com/file/scryfall-cards/art_crop/front/7/f/7f8b8a5b-d0f4-497e-8d73-72b0ff3799b7.jpg"
        )

        return listOf(
            RandomCard(
                "6ec7fa5b-d0f4-497e-8d73-72b0ff3799b6",
                "Lightning Bolt",
                "{R}",
                "Instant",
                "Lightning Bolt deals 3 damage to any target.",
                "Rage is a fuel that takes us further than we thought possible.",
                mockUrisCard1,
                "Limited Edition Alpha",
                "1993-08-05",
                "common",
                "Christopher Rush"
            ),
            RandomCard(
                "7f8b8a5b-d0f4-497e-8d73-72b0ff3799b7",
                "Counterspell",
                "{U}{U}",
                "Instant",
                "Counter target spell.",
                "The art of negation is a matter of debate.",
                mockUrisCard2,
                "Limited Edition Alpha",
                "1993-08-05",
                "uncommon",
                "Mark Poole"
            )
        )
    }
}