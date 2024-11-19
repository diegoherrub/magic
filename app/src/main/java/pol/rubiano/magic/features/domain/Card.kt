package pol.rubiano.magic.features.domain

data class Card(
    // Unique card ID
    @SerializedName("id") val id: String,
    // Card name
    @SerializedName("name") val name: String,
    // Mana cost (can be null if it has no cost)
    @SerializedName("mana_cost") val manaCost: String?,
    // Card type
    @SerializedName("type_line") val typeLine: String,
    // Rules text (can be null)
    @SerializedName("oracle_text") val oracleText: String?,
    // Card flavor text (can be null)
    @SerializedName("flavor_text") val flavorText: String?,
    // Card image URL
    @SerializedName("art_crop") val artCrop: ImageUris,
    // Set name
    @SerializedName("set_name") val setName: String,
    // Set release date
    @SerializedName("released_at") val releaseAt: String,
    // Card rarity
    @SerializedName("rarity") val rarity: String,
    // Artist name
    @SerializedName("artist") val artist: String,
)

data class ImageUris (
    @SerializedName("art_crop") val artCrop: String
)

