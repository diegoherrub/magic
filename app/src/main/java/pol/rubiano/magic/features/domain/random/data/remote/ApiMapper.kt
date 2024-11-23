package pol.rubiano.magic.features.domain.random.data.remote

import pol.rubiano.magic.features.domain.random.domain.RandomCard
import pol.rubiano.magic.features.domain.random.domain.ImageUris

fun RandomCardApiModel.toModel(): RandomCard {
    return RandomCard(
        this.id,
        this.name,
        this.manaCost,
        this.typeLine,
        this.oracleText,
        this.flavorText,
        ImageUris(this.artCrop.artCrop),
        this.setName,
        this.releasedAt,
        this.rarity,
        this.artist
    )
}