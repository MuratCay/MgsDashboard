package com.mgssoftware.mgsdashboard.avfast.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.mgssoftware.mgsdashboard.avfast.adapters.AvfastAssignmentAdapter
import com.mgssoftware.mgsdashboard.avfast.adapters.AvfastGraphicAdapter
import com.mgssoftware.mgsdashboard.avfast.adapters.AvfastRegistrantsAdapter
import com.mgssoftware.mgsdashboard.avfast.data.model.AvfastAPI
import com.mgssoftware.mgsdashboard.avfast.data.remote.AvfastRetrofitClient
import com.mgssoftware.mgsdashboard.avfast.ui.viewmodel.AvfastFragmentViewModel
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.data.repository.MainRepository
import com.mgssoftware.mgsdashboard.data.service.RetrofitAPI
import com.mgssoftware.mgsdashboard.databinding.FragmentAvfastBinding
import com.mgssoftware.mgsdashboard.ui.factory.ViewModelFactory
import retrofit2.Retrofit


class AvfastFragment : BaseFragment<FragmentAvfastBinding>(FragmentAvfastBinding::inflate) {

    private val retrofit: Retrofit by lazy {
        AvfastRetrofitClient.getAvfastRetrofitClient()
    }
    private val apiService: RetrofitAPI by lazy {
        retrofit.create(RetrofitAPI::class.java)
    }
    private val repository: MainRepository by lazy {
        MainRepository(apiService)
    }
    private val viewModel: AvfastFragmentViewModel by viewModels {
        ViewModelFactory(repository)
    }
    private lateinit var myAdapter: AvfastGraphicAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRegistrantsRecyclerView()
        configureAssignmentRecyclerView()
        viewModelObserver()
    }

    private fun viewModelObserver() {
        viewModel.numberOfUsers.observe(viewLifecycleOwner, ::numberOfUsersObserver)
        viewModel.getNumberOfUsers()
        viewModel.numberOfPeopleOnline.observe(viewLifecycleOwner, ::numberOfPeopleOnlineObserver)
        viewModel.getNumberOfPeopleOnline()
        viewModel.updateAvfastRecycler.observe(viewLifecycleOwner, ::updateAvfastRecyclerObserver)
        viewModel.getUpdateAvfastRecycler()
        viewModel.rvRegistrants.observe(viewLifecycleOwner, ::rvRegistrantsObserver)
        viewModel.getRvRegistrants()
        viewModel.numberOfRecentEvents.observe(viewLifecycleOwner, ::numberOfRecentEventsObserver)
        viewModel.getNumberOfRecentEvents()
        viewModel.rvAssignment.observe(viewLifecycleOwner, ::rvAssignmentObserver)
        viewModel.getRvAssignment()
        viewModel.numberOfRegistered.observe(viewLifecycleOwner, ::numberOfRegisteredObserver)
        viewModel.getNumberOfRegistered()
    }

    private fun numberOfUsersObserver(response: AvfastAPI?) {
        binding.numberOfUsers.text = response?.usersCount.toString()
    }

    private fun numberOfPeopleOnlineObserver(response: AvfastAPI?) {
        binding.numberOfPeopleOnline.text = response?.onlineUsersCount.toString()
    }

    @SuppressLint("SetTextI18n")
    private fun numberOfRegisteredObserver(response: AvfastAPI?) {
        binding.numberOfRegistered.text =
            "Kayıt Olanlar(${response?.registerUsers?.size.toString()})"
    }

    @SuppressLint("SetTextI18n")
    private fun numberOfRecentEventsObserver(response: AvfastAPI?) {
        binding.numberOfRecentEvents.text = "Son Olaylar(${response?.logs?.size.toString()})"
    }

    private fun rvAssignmentObserver(response: AvfastAPI?) {
        binding.rvAssignment.adapter = AvfastAssignmentAdapter(response?.logs)
    }

    private fun rvRegistrantsObserver(response: AvfastAPI?) {
        binding.rvRegistrants.adapter = AvfastRegistrantsAdapter(response?.registerUsers)
    }

    private fun updateAvfastRecyclerObserver(response: AvfastAPI?) {
        binding.rvGraphicAvfast.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE

        val list = listOf(
            "BU AY KAYITLI KULLANICI", "Günlük Giriş", "Yeni Task",
            "Başvurma", "Tamamlanan", "Değerlendirme"
        )
        response.let {
            myAdapter = it?.let { it1 -> AvfastGraphicAdapter(list, it1) }!!
        }
        binding.rvGraphicAvfast.apply {
            setHasFixedSize(true)
            adapter = myAdapter
        }
        binding.arIndicator.attachTo(binding.rvGraphicAvfast, true)
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




