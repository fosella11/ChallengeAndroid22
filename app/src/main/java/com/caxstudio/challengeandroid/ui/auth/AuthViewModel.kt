package com.caxstudio.challengeandroid.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.caxstudio.challengeandroid.data.model.auth.User
import com.caxstudio.challengeandroid.data.repository.AuthRepository
import com.caxstudio.challengeandroid.utils.UiProgress
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _registerUser = MutableLiveData<UiProgress<String>>()
    val createUser: LiveData<UiProgress<String>>
        get() = _registerUser

    private val _loginUser = MutableLiveData<UiProgress<String>>()
    val loginUser: LiveData<UiProgress<String>>
        get() = _loginUser

    fun getSession(result: (User?) -> Unit) {
        repository.getSession(result)
    }

    fun loginUser(
        email: String,
        password: String
    ) {
        _loginUser.value = UiProgress.Loading
        repository.loginUser(
            email,
            password
        ) { result ->
            _loginUser.value = result
        }
    }

    fun registerUser(
        email: String,
        password: String,
        user: User
    ) {
        _registerUser.value = UiProgress.Loading
        repository.registerUser(
            email = email,
            password = password,
            user = user
        ) { result ->
            _registerUser.value = result
        }
    }
}