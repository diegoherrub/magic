package pol.rubiano.magic.features.domain.random.presentation

import android.content.Context
import pol.rubiano.magic.app.data.api.ApiClient
import pol.rubiano.magic.features.domain.random.data.RandomCardDataRepository
import pol.rubiano.magic.features.domain.random.data.local.RandomCardXmlLocalDataSource
import pol.rubiano.magic.features.domain.random.data.remote.RandomCardApiRemoteDataSource
import pol.rubiano.magic.features.domain.random.data.remote.RandomCardMockRemoteDataSource
import pol.rubiano.magic.features.domain.random.domain.GetRandomCardUseCase

class RandomCardFactory(
    private val context: Context
) {

    private val randomCardXml = RandomCardXmlLocalDataSource(context)
    private val randomCardMock = RandomCardMockRemoteDataSource()
    private val randomCardApi = getRandomCardApiRemoteDataSource()
    private val randomCardDataRepository = RandomCardDataRepository(randomCardXml, randomCardMock, randomCardApi)
    private val getRandomCardUseCase = GetRandomCardUseCase(randomCardDataRepository)

    fun buildRandomCardViewModel() = RandomCardViewModel(getRandomCardUseCase)

    private fun getRandomCardApiRemoteDataSource(): RandomCardApiRemoteDataSource {
        val randomCardService = ApiClient.provideRandomCardService()
        return RandomCardApiRemoteDataSource(randomCardService)
    }
}