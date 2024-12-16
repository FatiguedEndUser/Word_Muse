package com.example.word_muse.ui.login

import android.os.Bundle
import android.view.AbsSavedState
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.word_muse.databinding.FragmentLoginBinding

class LoginFragment{
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        val root: View = binding.root
        return root
    }
}
