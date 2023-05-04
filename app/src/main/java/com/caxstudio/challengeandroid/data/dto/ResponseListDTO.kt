package com.caxstudio.challengeandroid.data.dto

data class ResponseListDto<T>(val info: Info, val results: List<T>) {

    data class Info(
        val count: Int,
        val next: String?,
        val pages: Int,
        val prev: String
    )
}