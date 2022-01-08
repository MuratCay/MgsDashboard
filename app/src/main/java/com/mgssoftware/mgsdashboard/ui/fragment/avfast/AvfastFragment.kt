package com.mgssoftware.mgsdashboard.ui.fragment.avfast

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.mgssoftware.mgsdashboard.adapters.avfastadapter.AvfastAssignmentAdapter
import com.mgssoftware.mgsdashboard.adapters.avfastadapter.AvfastGraphicAdapter
import com.mgssoftware.mgsdashboard.adapters.avfastadapter.AvfastRegistrantsAdapter
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.data.avfastmodel.AvfastAPI
import com.mgssoftware.mgsdashboard.data.remote.AvfastRetrofitClient
import com.mgssoftware.mgsdashboard.data.remote.RetrofitAPI
import com.mgssoftware.mgsdashboard.databinding.FragmentAvfastBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AvfastFragment : BaseFragment<FragmentAvfastBinding>(FragmentAvfastBinding::inflate) {

//    private val viewModel: AvfastFragmentViewModel by viewModels()

    private val retrofit = AvfastRetrofitClient.getAvfastRetrofitClient()
    private val apiService = retrofit.create(RetrofitAPI::class.java)

    private var myData: AvfastAPI? = null
    private lateinit var myAdapter: AvfastGraphicAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureRegistrantsRecyclerView()
        configureAssignmentRecyclerView()

        val callAvfast = apiService.getAvfastUser()

        callAvfast.enqueue(object : Callback<AvfastAPI> {
            override fun onResponse(call: Call<AvfastAPI>, response: Response<AvfastAPI>) {
                if (response.isSuccessful) {
                    response.let {
                        myData = response.body()
                        updateAvfastRecycler()
                        addIndicator()
                        binding.rvGraphicAvfast.visibility = View.VISIBLE
                        binding.progressBar?.visibility = View.GONE
                        binding.rvAssignment?.adapter = AvfastAssignmentAdapter(myData?.logs)
                        binding.rvRegistrants?.adapter =
                            AvfastRegistrantsAdapter(myData?.registerUsers)
                        binding.numberOfUsers.text = myData?.usersCount.toString()
                        binding.numberOfPeopleOnline.text = myData?.onlineUsersCount.toString()
                    }
                }
            }

            override fun onFailure(call: Call<AvfastAPI>, t: Throwable) {
                android.util.Log.e("Error", t.message.toString())
            }
        })

        /**
        CoroutineScope(Dispatchers.IO).launch {
        viewModel.getUserCountData()
        Log.e(TAG, "")

        }
        viewModel.users.observe(viewLifecycleOwner, { user ->
        Log.e(TAG, "$user")

        binding.numberOfUsers.text = user.toString()
        })
         */
    }

    private fun updateAvfastRecycler() {
        val list = listOf(
            "BU AY KAYITLI KULLANICI", "Günlük Giriş", "Yeni Task",
            "Başvurma", "Tamamlanan", "Değerlendirme"
        )

        myData?.let {
            myAdapter = AvfastGraphicAdapter(list, it)
        }

        binding.rvGraphicAvfast.setHasFixedSize(true)
        binding.rvGraphicAvfast.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvGraphicAvfast.adapter = myAdapter
    }

    private fun configureAssignmentRecyclerView() {
        binding.rvAssignment?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }
    }

    private fun configureRegistrantsRecyclerView() {
        binding.rvRegistrants?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }
    }

    private fun addIndicator() {
        binding.arIndicator?.attachTo(binding.rvGraphicAvfast, true)
    }

}


