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
import pol.rubiano.magic.app.domain.ErrorApp
import pol.rubiano.magic.databinding.FragmentRandomCardBinding

class RandomCardFragment: Fragment(
    R.layout.fragment_random_card
) {

    private lateinit var randomCardFactory: RandomCardFactory
    private lateinit var viewModel: RandomCardViewModel

    private var _binding: FragmentRandomCardBinding? = null
    private val binding get() = _binding!!

    private val randomCardAdapter = RandomCardAdapter()

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
        randomCardFactory = RandomCardFactory(requireContext())
        viewModel = randomCardFactory.buildRandomCardViewModel()
        viewModel.randomCardCreated()
        setupObserver()
    }

    private fun setupObserver() {
        val eventObserver = Observer<RandomCardViewModel.UiState> {
            it.randomCard?.let { card ->
                randomCardAdapter.submitList(card)
            }
            it.errorApp?.let {

            }
            if (it.isLoading) {
                Log.d("@dev", "Cargando setupObserver...")
            } else {
                Log.d("@dev", "Cargado!")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, eventObserver)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}