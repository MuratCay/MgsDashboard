package com.mgssoftware.mgsdashboard.ui.fragment.petner

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mgssoftware.mgsdashboard.adapters.petneradapter.PetnerAssignmentAdapter
import com.mgssoftware.mgsdashboard.adapters.petneradapter.PetnerGraphicAdapter
import com.mgssoftware.mgsdashboard.adapters.petneradapter.PetnerRegistrantsAdapter
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.data.petnermodel.Log
import com.mgssoftware.mgsdashboard.data.petnermodel.PetnerAPI
import com.mgssoftware.mgsdashboard.data.petnermodel.RegisterUser
import com.mgssoftware.mgsdashboard.data.remote.PetnerRetrofitClient
import com.mgssoftware.mgsdashboard.data.remote.RetrofitAPI
import com.mgssoftware.mgsdashboard.databinding.FragmentPetnerBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PetnerFragment : BaseFragment<FragmentPetnerBinding>(FragmentPetnerBinding::inflate) {

    private val retrofit = PetnerRetrofitClient.getPetnerRetrofitClient()
    private val apiService = retrofit.create(RetrofitAPI::class.java)
    private val viewModel: PetnerFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureGraphicRecyclerView()
        addIndicator()
        configureRegistrantsRecyclerView()
        configureAssignmentRecyclerView()

        val callPetner = apiService.getPetnerUser()
        callPetner.enqueue(object : Callback<PetnerAPI> {
            override fun onResponse(call: Call<PetnerAPI>, response: Response<PetnerAPI>) {
                val body = response.body()!!
                val dataLog: List<Log> = body.logs
                val dataRegistrants: List<RegisterUser> = body.registerUsers

                if (response.isSuccessful) {
                    binding.numberOfUsers.text = body.usersCount.toString()
                    binding.currentNumberOfPets.text = body.petsCount.toString()
                    binding.currentNumberOfAdoptions.text = body.adoptionPetsCount.toString()
                    binding.rvAssignment.adapter = PetnerAssignmentAdapter(dataLog)
                    binding.rvRegistrants.adapter = PetnerRegistrantsAdapter(dataRegistrants)
                }
            }

            override fun onFailure(call: Call<PetnerAPI>, t: Throwable) {
                Toast.makeText(requireContext(), "exception", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun configureAssignmentRecyclerView() {
        binding.rvAssignment.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }

    }

    private fun configureRegistrantsRecyclerView() {
        binding.rvRegistrants.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }
    }

    private fun configureGraphicRecyclerView() {
        val list = listOf(
            "BU AY KAYITLI KULLANICI", "Günlük Giriş", "Yeni POST(FORUM)",
            "CHAT SAYISI", "POST YORUM(FORUM)",
        )
        val descriptionList = listOf("10", "9", "7", "3", "3")
        val barBottomValue = arrayListOf("0", "1", "2", "3", "4", "5")
        val adapter = PetnerGraphicAdapter(list, descriptionList, barBottomValue)

        binding.rvGraphicPetner.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvGraphicPetner.adapter = adapter
    }

    private fun addIndicator() {
        binding.arIndicator.attachTo(binding.rvGraphicPetner, true)
    }
}