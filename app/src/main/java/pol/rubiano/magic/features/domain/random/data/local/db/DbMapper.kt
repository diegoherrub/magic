package pol.rubiano.magic.features.domain.random.data.local.db

import pol.rubiano.magic.features.domain.random.domain.ImageUris
import pol.rubiano.magic.features.domain.random.domain.RandomCard

fun RandomCard.toEntity(): RandomCardEntity =
    RandomCardEntity(
        this.id,
        this.name,
        this.manaCost,
        this.typeLine,
        this.oracleText,
        this.flavorText,
        this.artCrop.artCrop,
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
        ImageUris(this.artCrop),
        this.setName,
        this.releasedAt,
        this.rarity,
        this.artist
    )