package com.caxstudio.challengeandroid.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caxstudio.challengeandroid.domain.error.CharacterError
import com.caxstudio.challengeandroid.domain.model.Character
import com.caxstudio.challengeandroid.domain.model.CharacterDetailsExtended
import com.caxstudio.challengeandroid.domain.model.Gender
import com.caxstudio.challengeandroid.domain.usecase.GetCharacterDetails
import com.caxstudio.challengeandroid.domain.usecase.GetCharacters
import com.caxstudio.challengeandroid.domain.usecase.GetFilteredCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
This code defines a ViewModel class that is injectable with Hilt, which has dependencies to
get a list of characters, a filtered list of characters, and details for a specific character.
It also defines functions to filter the list of characters by sex and to load the details for
a specific character. The ViewModel uses LiveData to expose the list of characters and character
details to the view.
*/

@HiltViewModel // Marks this as a ViewModel that is injectable with Hilt
class CharacterViewModel @Inject constructor(
    private val getCharacters: GetCharacters, // Dependency to get a list of characters
    private val getFilteredCharacters: GetFilteredCharacters, // Dependency to get a filtered list of characters
    private val getCharacterDetails: GetCharacterDetails // Dependency to get details for a specific character
) : ViewModel() {

    private val _characters =
        MutableLiveData<List<Character>>() // LiveData to hold the list of characters
    val characters: LiveData<List<Character>> = _characters // Expose the LiveData to the view

    private val _characterDetails =
        MutableLiveData<CharacterDetailsExtended>() // LiveData to hold the details for a character
    val characterDetails: LiveData<CharacterDetailsExtended> =
        _characterDetails // Expose the LiveData to the view

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        getCharacters() // Load the list of characters on initialization
    }

    // Filter the list of characters to only show males
    fun filterBySexMale() {
        viewModelScope.launch {
            showLoading()
            getFilteredCharacters(params = GetFilteredCharacters.Params(Gender.Male)) {
                hideLoading()
                it.fold(::showError, ::showCharacters)
            }
        }
    }

    // Filter the list of characters to only show females
    fun filterBySexFemale() {
        viewModelScope.launch {
            showLoading()
            getFilteredCharacters(params = GetFilteredCharacters.Params(Gender.Female)) {
                hideLoading()
                it.fold(::showError, ::showCharacters)
            }
        }
    }

    // Show the full list of characters
    fun filterBySexAll() {
        viewModelScope.launch {
            getCharacters()
        }
    }

    // Load the list of characters
    private fun getCharacters() {
        showLoading()
        viewModelScope.launch {
            getCharacters(params = Unit) {
                hideLoading()
                it.fold(::showError, ::showCharacters)
            }
        }
    }

    // Update the LiveData with the list of characters
    private fun showCharacters(result: List<Character>) {
        _characters.postValue(result)
    }

    // Load the details for a specific character
    fun getCharacterDetails(id: Int) {
        showLoading()
        viewModelScope.launch {
            hideLoading()
            getCharacterDetails(params = GetCharacterDetails.Params(id)) { characterData ->
                characterData.fold(::showError, ifRight = { _characterDetails.postValue(it) })
            }
        }
    }

    // Log any errors that occur while loading the data
    private fun showError(error: CharacterError) {
        println(error.toString())
    }

    private fun showLoading(){
        _isLoading.postValue(true)
    }

    private fun hideLoading(){
        _isLoading.postValue(false)
    }
}