package com.caxstudio.challengeandroid.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caxstudio.challengeandroid.data.model.character.Result
import com.caxstudio.challengeandroid.data.repository.CharacterRepository
import com.caxstudio.challengeandroid.utils.UiProgress
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    private val _result = MutableLiveData<UiProgress<List<Result>>>()
    val results: LiveData<UiProgress<List<Result>>>
        get() = _result

    private val _logOut = MutableLiveData<Boolean>()
    val logOut: LiveData<Boolean>
        get() = _logOut

    // To show loading in requests
    // private - Only the class can modify
    fun getCharacters() {
        viewModelScope.launch {
            _result.value = UiProgress.Loading
            characterRepository.getCharacters { _result.value = it }
        }

    }

    fun logOut() {
        viewModelScope.launch {
            characterRepository.logout {
                _logOut.value = true
            }

        }
    }
}
