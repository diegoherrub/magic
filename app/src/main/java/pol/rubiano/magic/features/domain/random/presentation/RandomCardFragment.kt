package pol.rubiano.magic.features.domain.random.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import pol.rubiano.magic.R
import pol.rubiano.magic.databinding.FragmentRandomCardBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RandomCardFragment : Fragment(
    R.layout.fragment_random_card
) {
    private var _binding: FragmentRandomCardBinding? = null
    private val binding get() = _binding!!

    private val randomCardAdapter = RandomCardAdapter()
    private val viewModel: RandomCardViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRandomCardBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    private fun setupView() {
        binding.apply {
            randomCardList.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            randomCardList.adapter = randomCardAdapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.randomCardCreated()
        setupObserver()
    }

    private fun setupObserver() {
        val eventObserver = Observer<RandomCardViewModel.UiState> { uiState ->
            uiState.randomCard?.let { card ->
                randomCardAdapter.submitList(card)
            }
            uiState.errorApp?.let {
                Log.e("@dev", "Error: ${it.message}")
            } ?: run {
                Log.d("@dev", "Sin errores")
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