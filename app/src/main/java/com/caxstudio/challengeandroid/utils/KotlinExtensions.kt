package com.caxstudio.challengeandroid.utils

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun Fragment.toast(msg: String?) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
}

fun getTitleByRoute(route:String): String {
    Log.d("FEDE", route)

    return when (route) {
        "characters" -> "Characters"
        // other cases
        else -> "Details"
    }
}