package pol.rubiano.magic.features.randomCard.data.local

import android.content.Context
import com.google.gson.Gson
import org.koin.core.annotation.Single
import pol.rubiano.magic.R
import pol.rubiano.magic.features.randomCard.domain.RandomCard

@Single
class RandomCardXmlLocalDataSource(
    private val context: Context
) {

    private val sharedPref = context.getSharedPreferences(context.getString(R.string.string_random_card_file_xml), Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveXmlRandomCard(randomCard: RandomCard) {
        val editor = sharedPref.edit()
        editor.putString(randomCard.id, gson.toJson(randomCard))
        editor.apply()
    }

    fun saveAllXmlRandomCards(randomCards: List<RandomCard>) {
        val editor = sharedPref.edit()
        randomCards.forEach { randomCard ->
            editor.putString(randomCard.id, gson.toJson(randomCard))
        }
        editor.apply()
    }

    fun getAllXmlRandomCards(): List<RandomCard> {
        val randomCards = mutableListOf<RandomCard>()
        val mapRandomCard = sharedPref.all
        mapRandomCard.values.forEach {
            val randomCard = gson.fromJson(it as String, RandomCard::class.java)
            randomCards.add(randomCard)
        }
        return randomCards
    }
}