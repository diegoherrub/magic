package pol.rubiano.magic.features.randomCard.data.remote

import pol.rubiano.magic.features.randomCard.domain.RandomCard
import pol.rubiano.magic.features.randomCard.domain.ImageUris

fun RandomCardApiModel.toModel(): RandomCard {
    return RandomCard(
        this.id,
        this.name,
        this.manaCost,
        this.typeLine,
        this.oracleText,
        this.flavorText,
        ImageUris(this.imageUris.borderCrop),
        this.setName,
        this.releasedAt,
        this.rarity,
        this.artist
    )
}