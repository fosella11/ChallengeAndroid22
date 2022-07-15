package com.caxstudio.challengeandroid.ui.characters

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.caxstudio.challengeandroid.R
import com.caxstudio.challengeandroid.databinding.FragmentCharactersBinding
import com.caxstudio.challengeandroid.utils.UiProgress
import com.caxstudio.challengeandroid.utils.hide
import com.caxstudio.challengeandroid.utils.show
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_PARAM_CHARACTER = "character"

@Suppress("DEPRECATION")
@AndroidEntryPoint
class CharactersFragment : Fragment() {

    private val charactersViewModel: CharactersViewModel by viewModels()
    private lateinit var binding: FragmentCharactersBinding

    init {
        setHasOptionsMenu(true)
    }

    private val adapter by lazy {
        CharactersAdapter(
            onItemClicked = { _, item ->
                findNavController().navigate(
                    R.id.action_characterFragment_to_characterDetails,
                    Bundle().apply {
                        putParcelable(ARG_PARAM_CHARACTER, item)
                    })
            }
        )
    }

    class ExampleFragment : Fragment() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setHasOptionsMenu(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                charactersViewModel.logOut()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
                else -> {}
            }
        }
        charactersViewModel.logOut.observe(viewLifecycleOwner) { goToLogin ->
            if (goToLogin) {
                findNavController().navigate(R.id.action_characterFragment_to_loginFragment)
            }
        }
    }
}