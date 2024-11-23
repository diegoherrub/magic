package pol.rubiano.magic.features.domain.random.data.local

import android.content.Context
import com.google.gson.Gson
import pol.rubiano.magic.features.domain.random.domain.RandomCard

class RandomCardXmlLocalDataSource(
    private val context: Context
) {

    private val sharedPref = context.getSharedPreferences("randomCard", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveAllXmlRandomCards(randomCards: List<RandomCard>) {
        val editor = sharedPref.edit()
        randomCards.forEach {
            editor.putString(it.id, gson.toJson(it))
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