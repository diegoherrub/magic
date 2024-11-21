package pol.rubiano.magic.features.domain.random.presentation

import androidx.lifecycle.ViewModel
import pol.rubiano.magic.features.domain.random.domain.Card
import pol.rubiano.magic.features.domain.random.domain.GetRandomCardUseCase

class RandomCardViewModel(
    private val getRandomCardUseCase: GetRandomCardUseCase
): ViewModel() {

    fun viewCreated(): Card {
        return getRandomCardUseCase.invoke()
    }

    fun itemSelected(): Card {
        return getRandomCardUseCase.invoke()
    }
}