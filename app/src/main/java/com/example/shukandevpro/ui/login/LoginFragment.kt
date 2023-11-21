package com.example.shukandevpro.ui.login


import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.shukandevpro.MainActivity
import com.example.shukandevpro.UserViewModel
import com.example.shukandevpro.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }


    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val loginViewModel =
            ViewModelProvider(this).get(LoginViewModel::class.java)
        val userViewModel =
            ViewModelProvider(this).get(UserViewModel::class.java)


        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.vm = loginViewModel
        binding.userVm = userViewModel
        binding.lifecycleOwner = this

        loginViewModel.loginSuccess.observe(viewLifecycleOwner, Observer {
            if (it) {
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
            }
        })

        return binding.root
    }
}