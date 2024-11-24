package pol.rubiano.magic.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pol.rubiano.magic.features.randomCard.domain.random.data.local.db.RandomCardDao
import pol.rubiano.magic.features.randomCard.domain.random.data.local.db.RandomCardEntity

@Database(entities = [RandomCardEntity::class], version = 1, exportSchema = false)
abstract class RandomCardDataBase: RoomDatabase() {

    abstract fun randomCardDao(): RandomCardDao
}