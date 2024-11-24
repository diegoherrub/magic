package pol.rubiano.magic.features.randomCard.domain.random.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import pol.rubiano.magic.app.data.local.RandomCardDataBase
import pol.rubiano.magic.features.randomCard.domain.random.data.local.db.RandomCardDao
import pol.rubiano.magic.features.randomCard.domain.random.data.remote.RandomCardService
import retrofit2.Retrofit

@Module
@ComponentScan
class RandomCardModule {

    @Single
    fun provideRandomCardService(retrofit: Retrofit): RandomCardService = retrofit.create(
        RandomCardService::class.java)

    @Single
    fun provideRandomCardDao(db: RandomCardDataBase): RandomCardDao = db.randomCardDao()
}