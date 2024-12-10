package pol.rubiano.magic.features.randomCard.data.remote

import com.google.gson.annotations.SerializedName

/**
 * Data class representing a random card API model.
 *
 * This class is used to parse the JSON response from the Scryfall API.
 *
 * @property id The unique identifier of the card.
 * @property name The name of the card.
 * @property manaCost The mana cost of the card.
 * @property typeLine The type line of the card.
 * @property oracleText The oracle text of the card.
 * @property flavorText The flavor text of the card.
 * @property imageUris The image URIs of the card.
 * @property setName The name of the set the card belongs to.
 * @property releasedAt The release date of the card.
 * @property rarity The rarity of the card.
 * @property artist The artist of the card.
 */
data class RandomCardApiModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("mana_cost") val manaCost: String?,
    @SerializedName("type_line") val typeLine: String,
    @SerializedName("oracle_text") val oracleText: String?,
    @SerializedName("flavor_text") val flavorText: String?,
    @SerializedName("image_uris") val imageUris: ImageUris,
    @SerializedName("set_name") val setName: String,
    @SerializedName("released_at") val releasedAt: String,
    @SerializedName("rarity") val rarity: String,
    @SerializedName("artist") val artist: String,
)

/**
 * Data class representing the image URIs of a card.
 *
 * @property borderCrop The URL of the border crop image.
 */
data class ImageUris (
    @SerializedName("border_crop") val borderCrop: String
)