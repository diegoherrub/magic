package pol.rubiano.magic.features.domain.random.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val RANDOM_CARD_TABLE = "random_card"
const val RANDOM_CARD_ID = "id"

@Entity(tableName = RANDOM_CARD_TABLE)
class RandomCardEntity(
    @PrimaryKey @ColumnInfo(name = RANDOM_CARD_ID) val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "mana_cost") val manaCost: String?,
    @ColumnInfo(name = "type_line") val typeLine: String,
    @ColumnInfo(name = "oracle_text") val oracleText: String?,
    @ColumnInfo(name = "flavor_text") val flavorText: String?,
    @ColumnInfo(name = "art_crop") val artCrop: String,
    @ColumnInfo(name = "set_name") val setName: String,
    @ColumnInfo(name = "released_at") val releasedAt: String,
    @ColumnInfo(name = "rarity") val rarity: String,
    @ColumnInfo(name = "artist") val artist: String,
    @ColumnInfo(name = "modifiedAt") val modifiedAt: Long
)