package pol.rubiano.magic.app.di

import android.content.Context
import androidx.room.Room
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import pol.rubiano.magic.app.data.local.RandomCardDataBase

@Module
@ComponentScan
class LocalModule {

    @Single
    fun provideDatabase(context: Context): RandomCardDataBase {

        val db = Room.databaseBuilder(
            context,
            RandomCardDataBase::class.java,
            "random_card_database"
        )
        db.fallbackToDestructiveMigration()
        return db.build()
    }
}