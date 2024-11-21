package pol.rubiano.magic.features.domain.random.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import pol.rubiano.magic.R
import pol.rubiano.magic.features.domain.random.domain.Card

class RandomCardActivity: AppCompatActivity() {

    private val randomCardFactory: RandomCardFactory = RandomCardFactory()
    private val viewModel = randomCardFactory.buildRandomCardViewModel()

    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val randomCard = viewModel.viewCreated()
        bindData(randomCard)
        viewModel.itemSelected()
    }

    private fun bindData(randomCard: Card) {
        findViewById<TextView>(R.id.id).text = randomCard.id
        findViewById<TextView>(R.id.name).text = randomCard.name
        findViewById<TextView>(R.id.mana_cost).text = randomCard.manaCost
        findViewById<TextView>(R.id.type_line).text = randomCard.typeLine
        findViewById<TextView>(R.id.oracle_text).text = randomCard.oracleText
        findViewById<TextView>(R.id.flavor_text).text = randomCard.flavorText
        findViewById<TextView>(R.id.set_name).text = randomCard.setName
        findViewById<TextView>(R.id.released_at).text = randomCard.releaseAt
        findViewById<TextView>(R.id.rarity).text = randomCard.rarity
        findViewById<TextView>(R.id.artist).text = randomCard.artist
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}