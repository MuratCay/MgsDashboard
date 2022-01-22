package com.mgssoftware.mgsdashboard.petner.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.data.repository.MainRepository
import com.mgssoftware.mgsdashboard.data.service.RetrofitAPI
import com.mgssoftware.mgsdashboard.databinding.FragmentPetnerBinding
import com.mgssoftware.mgsdashboard.petner.adapters.PetnerAssignmentAdapter
import com.mgssoftware.mgsdashboard.petner.adapters.PetnerGraphicAdapter
import com.mgssoftware.mgsdashboard.petner.adapters.PetnerRegistrantsAdapter
import com.mgssoftware.mgsdashboard.petner.data.model.PetnerAPI
import com.mgssoftware.mgsdashboard.petner.data.remote.PetnerRetrofitClient
import com.mgssoftware.mgsdashboard.petner.ui.viewmodel.PetnerFragmentViewModel
import com.mgssoftware.mgsdashboard.ui.factory.ViewModelFactory
import retrofit2.Retrofit

class PetnerFragment : BaseFragment<FragmentPetnerBinding>(FragmentPetnerBinding::inflate) {

    private val retrofit: Retrofit by lazy {
        PetnerRetrofitClient.getPetnerRetrofitClient()
    }
    private val apiService: RetrofitAPI by lazy {
        retrofit.create(RetrofitAPI::class.java)
    }
    private val repository: MainRepository by lazy {
        MainRepository(apiService)
    }
    private val viewModel: PetnerFragmentViewModel by viewModels {
        ViewModelFactory(repository)
    }
    private lateinit var myAdapter: PetnerGraphicAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRegistrantsRecyclerView()
        configureAssignmentRecyclerView()
        viewModelObserver()
    }

    private fun viewModelObserver() {
        viewModel.numberOfUsers.observe(viewLifecycleOwner, ::numberOfUsersObserver)
        viewModel.getNumberOfUsers()
        viewModel.currentNumberOfPets.observe(viewLifecycleOwner, ::currentNumberOfPetsObserver)
        viewModel.getCurrentNumberOfPets()
        viewModel.currentNumberOfAdoptions.observe(
            viewLifecycleOwner,
            ::currentNumberOfAdoptionsObserver
        )
        viewModel.getCurrentNumberOfAdoptions()
        viewModel.updatePetnerRecycler.observe(viewLifecycleOwner, ::updateGraphicObserver)
        viewModel.getUpdatePetnerRecycler()
        viewModel.numberOfRegistered.observe(viewLifecycleOwner, ::numberOfRegisteredObserver)
        viewModel.getNumberOfRegistered()
        viewModel.rvRegistrants.observe(viewLifecycleOwner, ::rvRegistrantsObserver)
        viewModel.getRvRegistrants()
        viewModel.numberOfRecentEvents.observe(viewLifecycleOwner, ::numberOfRecentEventsObserver)
        viewModel.getNumberOfRecentEvents()
        viewModel.rvAssignment.observe(viewLifecycleOwner, ::rvAssignmentObserver)
        viewModel.getRvAssignment()
    }

    @SuppressLint("SetTextI18n")
    private fun numberOfRecentEventsObserver(response: PetnerAPI?) {
        binding.numberOfRecentEvents.text = "Son Olaylar(${response?.logs?.size.toString()})"
    }

    @SuppressLint("SetTextI18n")
    private fun numberOfRegisteredObserver(response: PetnerAPI?) {
        binding.numberOfRegistered.text = "Kayıt Olanlar(${response?.registerUsers?.size})"
    }

    private fun currentNumberOfAdoptionsObserver(response: PetnerAPI?) {
        binding.currentNumberOfAdoptions.text = response?.adoptionPetsCount.toString()
    }

    private fun currentNumberOfPetsObserver(response: PetnerAPI?) {
        binding.currentNumberOfPets.text = response?.petsCount.toString()
    }

    private fun numberOfUsersObserver(response: PetnerAPI?) {
        binding.numberOfUsers.text = response?.usersCount.toString()
    }

    private fun rvAssignmentObserver(response: PetnerAPI?) {
        binding.rvAssignment.adapter = PetnerAssignmentAdapter(response?.logs)
    }

    private fun rvRegistrantsObserver(response: PetnerAPI?) {
        binding.rvRegistrants.adapter = PetnerRegistrantsAdapter(response?.registerUsers)
    }

    private fun updateGraphicObserver(response: PetnerAPI?) {
        binding.progressBar.visibility = View.GONE
        binding.rvGraphicPetner.visibility = View.VISIBLE

        val list = listOf(
            "BU AY KAYITLI KULLANICI", "Günlük Giriş", "Yeni POST(FORUM)",
            "CHAT SAYISI", "POST YORUM(FORUM)",
        )
        response.let {
            myAdapter = it?.let { it1 -> PetnerGraphicAdapter(list, it1) }!!
        }
        binding.rvGraphicPetner.apply {
            setHasFixedSize(true)
            adapter = myAdapter
        }
        binding.arIndicator.attachTo(binding.rvGraphicPetner, true)
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
}
