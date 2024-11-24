package pol.rubiano.magic.features.randomCard.domain.random.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import pol.rubiano.magic.app.extensions.loadUrl
import pol.rubiano.magic.databinding.FragmentRandomCardBinding
import pol.rubiano.magic.features.randomCard.domain.random.domain.RandomCard

class RandomCardViewHolder(
    private val view: View
): RecyclerView.ViewHolder(view) {

    private lateinit var binding: FragmentRandomCardBinding

    fun bind(randomCard: RandomCard) {
        binding = FragmentRandomCardBinding.bind(view)
        binding.apply {
            id.text = randomCard.id
            name.text = randomCard.name
            manaCost.text = randomCard.manaCost
            typeLine.text = randomCard.typeLine
            oracleText.text = randomCard.oracleText
            flavorText.text = randomCard.flavorText
            cardArtCrop.loadUrl(randomCard.artCrop.artCrop)
            setName.text = randomCard.setName
            releasedAt.text = randomCard.releasedAt
            rarity.text = randomCard.rarity
            artist.text = randomCard.artist
        }
    }
}