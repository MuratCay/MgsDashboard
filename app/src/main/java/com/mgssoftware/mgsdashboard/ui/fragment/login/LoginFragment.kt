package com.mgssoftware.mgsdashboard.ui.fragment.login

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.databinding.FragmentLoginBinding


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkUser()
        hideKeyboard()
    }

    private fun checkUser() {
        binding.btnLogin.setOnClickListener {
            if (binding.edtEmail.text?.isNotEmpty() == true && binding.edtPassword.text?.isNotEmpty() == true) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    binding.edtEmail.text.toString(),
                    binding.edtPassword.text.toString()
                ).addOnCompleteListener { p0 ->
                    if (p0.isSuccessful) {
                        Toast.makeText(
                            requireContext(),
                            "Başarılı Giriş: " + FirebaseAuth.getInstance().currentUser?.email,
                            Toast.LENGTH_SHORT
                        ).show()
                        FirebaseAuth.getInstance().signOut()
                        val action = LoginFragmentDirections.actionLoginFragmentToMainPageFragment()
                        findNavController().navigate(action)
                    } else {
                        if (binding.edtEmail.text?.isNotEmpty() == true) {
                            Toast.makeText(
                                requireContext(),
                                "E-postanız yada Şifreniz boş veya yanlış!",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }
                }
            } else {
                Toast.makeText(requireContext(), "Boş alanları doldurunuz!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun hideKeyboard() {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
        binding.constraintLayout.setOnTouchListener { _, _ ->
            hideKeyboard()
            false
        }
    }
}