package pol.rubiano.magic.features.domain.random.domain

data class RandomCard(
    // Unique card ID
    val id: String,
    // Card name
    val name: String,
    // Mana cost (can be null if it has no cost)
    val manaCost: String?,
    // Card type
    val typeLine: String,
    // Rules text (can be null)
    val oracleText: String?,
    // Card flavor text (can be null)
    val flavorText: String?,
    // Card image URL
    val artCrop: ImageUris,
    // Set name
    val setName: String,
    // Set release date
    val releasedAt: String,
    // Card rarity
    val rarity: String,
    // Artist name
    val artist: String,
)

data class ImageUris(
    val artCrop: String
)

