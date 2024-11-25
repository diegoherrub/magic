package pol.rubiano.magic.features.randomCard.data.local.db

import org.koin.core.annotation.Single
import pol.rubiano.magic.features.randomCard.domain.RandomCard

@Single
class RandomCardDbLocalDataSource(
    private val randomCardDao: RandomCardDao
) {

    suspend fun insertAllDbRandomCards(randomCards: List<RandomCard>) {
        val randomCardsList = randomCards.map {
            it.toEntity()
        }
        randomCardDao.insertAll(*randomCardsList.toTypedArray())
    }

    suspend fun getAllDbRandomCards(): List<RandomCard> {
        val randomCardEntities = randomCardDao.selectAll()
        return randomCardEntities.map {
            it.toDomain()
        }
    }
}