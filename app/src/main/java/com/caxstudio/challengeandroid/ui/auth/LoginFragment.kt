package com.caxstudio.challengeandroid.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.caxstudio.challengeandroid.R
import com.caxstudio.challengeandroid.databinding.FragmentLoginBinding
import com.caxstudio.challengeandroid.utils.UiProgress
import com.caxstudio.challengeandroid.utils.hide
import com.caxstudio.challengeandroid.utils.show
import com.caxstudio.challengeandroid.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observers()
        binding.mbLoginSignIn.setOnClickListener {
            if (checkData()) {
                viewModel.loginUser(
                    email = binding.etLoginEmail.text.toString(),
                    password = binding.etLoginPass.text.toString()
                )
            }
        }

        binding.tvLoginRegister.setOnClickListener {
            findNavController().navigate(
                R.id.action_loginFragment_to_registerFragment
            )
        }
    }

    private fun checkData(): Boolean {
        val emailIsReady: Boolean
        val passIsReady: Boolean
        if (binding.etLoginEmail.text.isNullOrEmpty()) {
            emailIsReady = false
            toast(getString(R.string.fragment_must_email))
            return emailIsReady
        } else {
            emailIsReady = true
        }
        if (binding.etLoginPass.text.isNullOrEmpty()) {
            passIsReady = false
            toast(getString(R.string.fragment_must_epass))
            return passIsReady
        } else {
            passIsReady = true
        }
        return emailIsReady && passIsReady
    }

    override fun onStart() {
        super.onStart()
        viewModel.getSession { userSession ->
            if (userSession != null) {
                findNavController().navigate(R.id.action_loginFragment_to_characterFragment)
            }
        }
    }

    private fun observers() {
        viewModel.loginUser.observe(viewLifecycleOwner) { progress ->
            when (progress) {
                is UiProgress.Loading -> {
                    binding.mbLoginSignIn.text = ""
                    binding.progressLoginSignIn.show()
                }
                is UiProgress.Failure -> {
                    binding.mbLoginSignIn.text =
                        getString(R.string.fragment_login_button_name)
                    binding.progressLoginSignIn.hide()
                    toast(getString(R.string.fragment_error_login))
                }
                is UiProgress.Success -> {
                    binding.mbLoginSignIn.text =
                        getString(R.string.fragment_login_button_name)
                    binding.progressLoginSignIn.hide()
                    toast(progress.data)
                    findNavController().navigate(R.id.action_loginFragment_to_characterFragment)
                }
            }

        }
    }
}