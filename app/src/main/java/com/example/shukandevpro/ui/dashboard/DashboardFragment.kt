package com.example.shukandevpro.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.shukandevpro.UserViewModel
import com.example.shukandevpro.databinding.FragmentDashboardBinding
import com.example.shukandevpro.databinding.FragmentHomeBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        val userViewModel =
            ViewModelProvider(this).get(UserViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        binding.vm = dashboardViewModel
        binding.userVm = userViewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}