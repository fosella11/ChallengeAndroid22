package com.caxstudio.challengeandroid.ui.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.caxstudio.challengeandroid.data.model.character.Result
import com.caxstudio.challengeandroid.databinding.FragmentCharacterDetailsBinding
import com.caxstudio.challengeandroid.di.GlideApp

private const val ARG_PARAM_CHARACTER = "character"

class CharacterDetailsFragment : Fragment() {

    var resultData: Result? = null
    lateinit var binding: FragmentCharacterDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (this::binding.isInitialized) {
            return binding.root
        } else {
            binding = FragmentCharacterDetailsBinding.inflate(layoutInflater)
            return binding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUI()
    }

    private fun updateUI() {
        resultData = arguments?.getParcelable(ARG_PARAM_CHARACTER)
        resultData?.let {
            binding.tvDetailsName.text = it.name
            binding.tvDetailsStatus.text = it.status
            binding.tvDetailsSpecies.text = it.species
            binding.tvDetailsGender.text = it.gender
            binding.tvDetailsOrigin.text = it.origin.name
            binding.tvDetailsLocation.text = it.location.name
            binding.tvDetailsEpisodes.text = it.episode.size.toString()

            // Glide generated API from AppGlideModule.
            GlideApp.with(binding.root)
                // Here you specify which image should be loaded by providing Uri.
                .load(it.image)
                .into(binding.ivDetailsImage)
        }
    }
}