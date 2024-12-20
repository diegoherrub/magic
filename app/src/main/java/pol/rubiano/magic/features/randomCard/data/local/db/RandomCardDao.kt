package pol.rubiano.magic.features.randomCard.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RandomCardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(randomCard: RandomCardEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg randomCars: RandomCardEntity)

    @Query("SELECT * FROM $RANDOM_CARD_TABLE")
    suspend fun selectAll(): List<RandomCardEntity>
}