package com.example.word_muse.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.word_muse.databinding.FragmentLoginBinding
import com.example.word_muse.databinding.FragmentLoginBinding.inflate

class LoginFragment : Fragment(){
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        _binding = inflate(
            inflater,
            container,
            false
        )

        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
