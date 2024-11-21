package pol.rubiano.magic.features.domain.random.presentation

import pol.rubiano.magic.features.domain.random.data.RandomCardDataRepository
import pol.rubiano.magic.features.domain.random.data.remote.RandomApiRemoteDataSource
import pol.rubiano.magic.features.domain.random.data.remote.RandomCardMockRemoteDataSource
import pol.rubiano.magic.features.domain.random.data.remote.RandomCardService
import pol.rubiano.magic.features.domain.random.domain.GetRandomCardUseCase

class RandomCardFactory {

    fun buildRandomCardViewModel(): RandomCardViewModel {
        return RandomCardViewModel(
            GetRandomCardUseCase(
                RandomCardDataRepository(
                    RandomCardMockRemoteDataSource()
                )
            )
        )
    }
}