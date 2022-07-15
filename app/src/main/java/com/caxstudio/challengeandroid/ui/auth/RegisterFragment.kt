package com.caxstudio.challengeandroid.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.caxstudio.challengeandroid.R
import com.caxstudio.challengeandroid.data.model.auth.User
import com.caxstudio.challengeandroid.databinding.FragmentRegisterBinding
import com.caxstudio.challengeandroid.utils.UiProgress
import com.caxstudio.challengeandroid.utils.hide
import com.caxstudio.challengeandroid.utils.show
import com.caxstudio.challengeandroid.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private lateinit var binnding: FragmentRegisterBinding
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binnding = FragmentRegisterBinding.inflate(inflater)
        return binnding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observers()
        binnding.mbRegisterSignIn.setOnClickListener {
            val check = checkData()
            if (check) {
                val dataEmail = binnding.etRegisterEmail.text.toString()
                val dataPass = binnding.etRegisterPass.text.toString()
                viewModel.registerUser(
                    email = dataEmail,
                    password = dataPass,
                    User(email = dataEmail, password = dataPass)
                )
            }
        }
    }

    private fun observers() {
        viewModel.createUser.observe(viewLifecycleOwner) { progress ->
            when (progress) {
                is UiProgress.Loading -> {
                    binnding.mbRegisterSignIn.text = ""
                    binnding.progressRegisterSignIn.show()
                }
                is UiProgress.Failure -> {
                    binnding.mbRegisterSignIn.text =
                        getString(R.string.fragment_register_button_name)
                    binnding.progressRegisterSignIn.hide()
                    toast(progress.data)
                }
                is UiProgress.Success -> {
                    binnding.mbRegisterSignIn.text =
                        getString(R.string.fragment_register_button_name)
                    binnding.progressRegisterSignIn.hide()
                    toast(progress.data)

                }
            }
        }
    }

    private fun checkData(): Boolean {
        val emailIsReady: Boolean
        val passIsReady: Boolean

        if (binnding.etRegisterEmail.text.isNullOrEmpty()) {
            emailIsReady = false
            toast(getString(R.string.fragment_must_email))
            return emailIsReady
        } else {
            emailIsReady = true
        }

        if (binnding.etRegisterPass.text.isNullOrEmpty()) {
            passIsReady = false
            toast(getString(R.string.fragment_must_epass))
            return passIsReady
        } else {
            passIsReady = true
        }
        return emailIsReady && passIsReady
    }
}