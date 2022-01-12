package com.mgssoftware.mgsdashboard.ui.fragment.petner

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.mgssoftware.mgsdashboard.adapters.petneradapter.PetnerAssignmentAdapter
import com.mgssoftware.mgsdashboard.adapters.petneradapter.PetnerGraphicAdapter
import com.mgssoftware.mgsdashboard.adapters.petneradapter.PetnerRegistrantsAdapter
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.data.petnermodel.PetnerAPI
import com.mgssoftware.mgsdashboard.data.remote.PetnerRetrofitClient
import com.mgssoftware.mgsdashboard.data.remote.RetrofitAPI
import com.mgssoftware.mgsdashboard.databinding.FragmentPetnerBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PetnerFragment : BaseFragment<FragmentPetnerBinding>(FragmentPetnerBinding::inflate) {

    private val retrofit = PetnerRetrofitClient.getPetnerRetrofitClient()
    private val apiService = retrofit.create(RetrofitAPI::class.java)

    private var myData: PetnerAPI? = null
    private lateinit var myAdapter: PetnerGraphicAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureRegistrantsRecyclerView()
        configureAssignmentRecyclerView()

        val callPetner = apiService.getPetnerUser()

        callPetner.enqueue(object : Callback<PetnerAPI> {
            override fun onResponse(call: Call<PetnerAPI>, response: Response<PetnerAPI>) {
                if (response.isSuccessful) {
                    response.let {
                        myData = response.body()
                        updateGraphicRecyclerView()
                        addIndicator()
                        binding.progressBar.visibility = View.GONE
                        binding.rvGraphicPetner.visibility = View.VISIBLE
                        binding.rvAssignment.adapter = PetnerAssignmentAdapter(myData?.logs)
                        binding.rvRegistrants.adapter =
                            PetnerRegistrantsAdapter(myData?.registerUsers)
                        binding.numberOfUsers.text = myData?.usersCount.toString()
                        binding.currentNumberOfPets.text = myData?.petsCount.toString()
                        binding.currentNumberOfAdoptions.text = myData?.adoptionPetsCount.toString()
                    }
                }
            }

            override fun onFailure(call: Call<PetnerAPI>, t: Throwable) {
                Log.e("Petner Data", t.message.toString())
            }
        })
    }
    private fun updateGraphicRecyclerView() {
        val list = listOf(
            "BU AY KAYITLI KULLANICI", "Günlük Giriş", "Yeni POST(FORUM)",
            "CHAT SAYISI", "POST YORUM(FORUM)",
        )

        myData?.let {
            myAdapter = PetnerGraphicAdapter(list, it)
        }
        binding.rvGraphicPetner.adapter = myAdapter
    }
    private fun configureAssignmentRecyclerView() {
        binding.rvAssignment.apply {
            setHasFixedSize(true)
        }
    }
    private fun configureRegistrantsRecyclerView() {
        binding.rvRegistrants.apply {
            setHasFixedSize(true)
        }
    }
    private fun addIndicator() {
        binding.arIndicator.attachTo(binding.rvGraphicPetner, true)
    }
}