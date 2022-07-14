package com.caxstudio.challengeandroid.ui.episodes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caxstudio.challengeandroid.data.model.Episodes
import com.caxstudio.challengeandroid.data.repository.EpisodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val episodesRepositoryImp: EpisodeRepository
) : ViewModel() {
    fun getEpisodes() {
        viewModelScope.launch(Dispatchers.IO) {
            _inProgress.postValue(true)
            episodesRepositoryImp.getEpisodes()
            _inProgress.postValue(false)
        }
    }

    // To show loading in requests
    // private - Only the class can modify
    private val _inProgress: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }
    val inProgress: LiveData<Boolean> get() = _inProgress

    private val _episodes: MutableLiveData<Episodes> by lazy {
        MutableLiveData<Episodes>()
    }
    val episodes: LiveData<Episodes> get() = _episodes

}
