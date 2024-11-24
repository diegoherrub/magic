package pol.rubiano.magic.features.randomCard.domain.random.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import pol.rubiano.magic.R
import pol.rubiano.magic.databinding.FragmentRandomCardItemBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RandomCardItemFragment : Fragment(
    R.layout.fragment_random_card_item
) {
    private var _binding: FragmentRandomCardItemBinding? = null
    private val binding get() = _binding!!

    private val randomCardAdapter = RandomCardAdapter()
    private val viewModel: RandomCardViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRandomCardItemBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    private fun setupView() {
        binding.apply {
            fragmentRandomCardItemView.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            fragmentRandomCardItemView.adapter = randomCardAdapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view)
        viewModel.randomCardCreated()
        setupObserver()
    }

    private fun setupObserver() {
        val eventObserver = Observer<RandomCardViewModel.UiState> { uiState ->
            uiState.randomCard?.let { card ->
                randomCardAdapter.submitList(card)
            }
            uiState.errorApp?.let {
                Log.e("@dev", "Error App en setupObserver(): ${it.message}")
            } ?: run {
                Log.d("@dev", "Sin errores en setupObserver()")
            }

            if (uiState.isLoading) {
                Log.d("@dev", "Cargando Random Card...")
            } else {
                Log.d("@dev", "Cargada Random Card!")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, eventObserver)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}