package pol.rubiano.magic.features.randomCard.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import pol.rubiano.magic.R
import pol.rubiano.magic.features.randomCard.domain.RandomCard

class RandomCardAdapter():
    ListAdapter<RandomCard, RandomCardViewHolder>(RandomCardDiffUtil())
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_random_card, parent, false)
        return RandomCardViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(
        holder: RandomCardViewHolder,
        position: Int
    ) {
        holder.bind(currentList[position])
    }
}