package pol.rubiano.magic.features.randomCard.data.remote

import com.google.gson.annotations.SerializedName

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

data class ImageUris (
    @SerializedName("border_crop") val borderCrop: String
)