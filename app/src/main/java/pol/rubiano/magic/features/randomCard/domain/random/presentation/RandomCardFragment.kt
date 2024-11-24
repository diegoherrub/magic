package pol.rubiano.magic.features.randomCard.domain.random.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pol.rubiano.magic.R

class RandomCardFragment : Fragment(
    R.layout.fragment_random_card
) {

    private var _binding: RandomCardFragmentBinding? = null
    private val binding get() = _binding!!

    private val randomCardAdapter = RandomCardAdapter()
    private val viewModel: RandomCardViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RandomCardFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}