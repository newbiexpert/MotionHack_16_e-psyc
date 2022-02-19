package com.motionlaboratory.e_psyc.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.motionlaboratory.e_psyc.databinding.FragmentDashboardBinding
import com.motionlaboratory.e_psyc.ui.main.MainViewModel
import com.motionlaboratory.e_psyc.utils.observe
import com.motionlaboratory.e_psyc.utils.showToast
import timber.log.Timber

class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding
    private val viewModel by lazy { ViewModelProvider(requireActivity()).get(MainViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getDoctor()
    }

    private fun setupObserver() {
        observe(viewModel.doctors) {
            Timber.e("$it")
            //adapter.setData(it)
        }
        observe(viewModel.message) { message ->
            showToast(message)
        }
    }

}