package com.mgssoftware.mgsdashboard.ui.fragment.splash

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val counter = object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.e("CountDownTimer", "seconds remaining: ${millisUntilFinished / 1000}")

            }
            override fun onFinish() {
                val action = SplashFragmentDirections.actionSplashFragmentToLoginFragment()
                findNavController().navigate(action)
            }
        }
        counter.start()
    }
}


