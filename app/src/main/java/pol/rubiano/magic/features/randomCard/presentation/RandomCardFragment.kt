package pol.rubiano.magic.features.randomCard.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import pol.rubiano.magic.databinding.FragmentRandomCardBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import pol.rubiano.magic.app.extensions.loadUrl

class RandomCardFragment : Fragment() {

    private var _binding: FragmentRandomCardBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RandomCardViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRandomCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.uiState.observe(viewLifecycleOwner) { uiState ->
            uiState.randomCard?.let { randomCard ->
                binding.apply {
                    id.text = randomCard.id
                    name.text = randomCard.name
                    manaCost.text = randomCard.manaCost
                    typeLine.text = randomCard.typeLine
                    oracleText.text = randomCard.oracleText
                    flavorText.text = randomCard.flavorText
                    setName.text = randomCard.setName
                    releasedAt.text = randomCard.releasedAt
                    rarity.text = randomCard.rarity
                    artist.text = randomCard.artist
                    cardArtCrop.loadUrl(randomCard.borderCrop.borderCrop)
                }
            }
        }

        viewModel.randomCardViewCreated()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}