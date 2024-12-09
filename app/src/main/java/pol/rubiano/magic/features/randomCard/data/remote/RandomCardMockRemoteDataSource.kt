package pol.rubiano.magic.features.randomCard.data.remote

import org.koin.core.annotation.Single
import pol.rubiano.magic.features.randomCard.domain.RandomCard
import pol.rubiano.magic.features.randomCard.domain.ImageUris

@Single
class RandomCardMockRemoteDataSource {

    fun getMockRandomCard(): RandomCard {

        val mockUrisCard1 = ImageUris(
            borderCrop = "https://c1.scryfall.com/file/scryfall-cards/art_crop/front/6/e/6ec7fa5b-d0f4-497e-8d73-72b0ff3799b6.jpg"
        )

        return RandomCard(
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
        )
    }
}