package com.caxstudio.challengeandroid.domain.error

sealed class CharacterError {
    object UnknownError : CharacterError()
}