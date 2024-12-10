package pol.rubiano.magic.features.randomCard.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import pol.rubiano.magic.app.domain.ErrorApp
import pol.rubiano.magic.features.randomCard.domain.RandomCard
import pol.rubiano.magic.features.randomCard.domain.GetRandomCardUseCase

@KoinViewModel
class RandomCardViewModel(
    private val getRandomCardUseCase: GetRandomCardUseCase
): ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState

    fun randomCardViewCreated() {

        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val randomCard = getRandomCardUseCase.invoke()
            _uiState.postValue(
                UiState(
                    randomCard = randomCard.getOrNull(),
                    errorApp = randomCard.exceptionOrNull() as ErrorApp?
                )
            )
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val randomCard: RandomCard? = null
    )
}