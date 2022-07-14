package com.caxstudio.challengeandroid.utils

sealed class UiProgress<out T> {
    object Loading : UiProgress<Nothing>()
    data class Success<out T>(val data: T) : UiProgress<T>()
}