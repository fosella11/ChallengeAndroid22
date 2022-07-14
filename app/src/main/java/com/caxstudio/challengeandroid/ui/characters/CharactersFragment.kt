package com.caxstudio.challengeandroid.ui.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.caxstudio.challengeandroid.R
import com.caxstudio.challengeandroid.databinding.FragmentCharactersBinding
import com.caxstudio.challengeandroid.utils.UiProgress
import com.caxstudio.challengeandroid.utils.hide
import com.caxstudio.challengeandroid.utils.show
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_PARAM_CHARACTER = "character"

@AndroidEntryPoint
class CharactersFragment : Fragment() {

    private val charactersViewModel: CharactersViewModel by viewModels()
    private lateinit var binding: FragmentCharactersBinding

    val adapter by lazy {
        CharactersAdapter(
            onItemClicked = { pos, item ->
                findNavController().navigate(R.id.action_characterFragment_to_characterDetails,Bundle().apply {
                    putParcelable(ARG_PARAM_CHARACTER,item)
                })
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (this::binding.isInitialized) {
            binding.root
        } else {
            binding = FragmentCharactersBinding.inflate(layoutInflater)
            binding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observer()
        binding.recyclerView.adapter = adapter

        charactersViewModel.getCharacters()
    }

    private fun observer() {
        charactersViewModel.results.observe(viewLifecycleOwner) { progress ->
            when (progress) {
                is UiProgress.Loading -> {
                    binding.progressBar.show()
                }
                is UiProgress.Success -> {
                    binding.progressBar.hide()
                    adapter.updateResults(episodeList = progress.data.toMutableList())
                }
            }

        }
    }
}