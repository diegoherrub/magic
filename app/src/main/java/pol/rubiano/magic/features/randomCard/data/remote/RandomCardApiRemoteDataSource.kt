package pol.rubiano.magic.features.randomCard.data.remote


import android.util.Log
import org.koin.core.annotation.Single
import pol.rubiano.magic.app.data.remote.apiCall
import pol.rubiano.magic.features.randomCard.domain.RandomCard


/**
 * Fetches a random Magic: The Gathering card from the remote API.
 *
 * This data source uses the `RandomCardService` to request a random card
 * (e.g., from the entire card database or within specific criteria)
 * and maps the API response to a domain model representation.
 */
@Single
class RandomCardApiRemoteDataSource(
    private val randomCardService: RandomCardService
) {

    /**
     * Fetches a random card from the API.
     *
     * @return A `Result` containing a [RandomCard] if successful, or an error if the
     * API call fails.
     */
    suspend fun getApiRandomCard(): Result<RandomCard> {
        Log.d("@Diego", "RandomCardApiRemoteDataSource -> entra en getApiRandomCard()")
        return apiCall {
            randomCardService.getRandomCard()
        }.map { randomCard ->
            Log.d("@Diego", "RandomCardApiRemoteDataSource -> randomCard: $randomCard")
            randomCard.toModel()
        }
    }
}