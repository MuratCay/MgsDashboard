package com.mgssoftware.mgsdashboard.ui.fragment.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkUser()
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
                        Toast.makeText(
                            requireContext(),
                            "Hatalı Giriş: " + p0.exception?.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } else {
                Toast.makeText(requireContext(), "Boş alanları doldurunuz!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

}