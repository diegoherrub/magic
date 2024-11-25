package pol.rubiano.magic.features.randomCard.domain

data class RandomCard(
    val id: String,
    val name: String,
    val manaCost: String?,
    val typeLine: String,
    val oracleText: String?,
    val flavorText: String?,
    val artCrop: ImageUris,
    val setName: String,
    val releasedAt: String,
    val rarity: String,
    val artist: String,
)

data class ImageUris(
    val artCrop: String
)

