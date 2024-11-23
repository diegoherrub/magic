package pol.rubiano.magic.features.domain.random.presentation

import androidx.recyclerview.widget.DiffUtil
import pol.rubiano.magic.features.domain.random.domain.RandomCard

class RandomCardDiffUtil: DiffUtil.ItemCallback<RandomCard>() {

    override fun areItemsTheSame(oldItem: RandomCard, newItem: RandomCard): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RandomCard, newItem: RandomCard): Boolean {
        return oldItem == newItem
    }
}