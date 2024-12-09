package pol.rubiano.magic.features.randomCard.data.local.db

import pol.rubiano.magic.features.randomCard.domain.ImageUris
import pol.rubiano.magic.features.randomCard.domain.RandomCard

fun RandomCard.toEntity(): RandomCardEntity =
    RandomCardEntity(
        this.id,
        this.name,
        this.manaCost,
        this.typeLine,
        this.oracleText,
        this.flavorText,
        this.borderCrop.borderCrop,
        this.setName,
        this.releasedAt,
        this.rarity,
        this.artist,
        System.currentTimeMillis()
    )

fun RandomCardEntity.toDomain(): RandomCard =
    RandomCard(
        this.id,
        this.name,
        this.manaCost,
        this.typeLine,
        this.oracleText,
        this.flavorText,
        ImageUris(this.borderCrop),
        this.setName,
        this.releasedAt,
        this.rarity,
        this.artist
    )