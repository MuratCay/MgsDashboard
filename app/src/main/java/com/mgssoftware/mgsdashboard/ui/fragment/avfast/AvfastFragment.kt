package com.mgssoftware.mgsdashboard.ui.fragment.avfast

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.adapters.avfastadapter.AvfastAssignmentAdapter
import com.mgssoftware.mgsdashboard.adapters.avfastadapter.AvfastGraphicAdapter
import com.mgssoftware.mgsdashboard.adapters.avfastadapter.AvfastRegistrantsAdapter
import com.mgssoftware.mgsdashboard.base.BaseFragment
import com.mgssoftware.mgsdashboard.data.avfastmodel.AvfastAPI
import com.mgssoftware.mgsdashboard.data.avfastmodel.Log
import com.mgssoftware.mgsdashboard.data.avfastmodel.RegisterUser
import com.mgssoftware.mgsdashboard.data.remote.RetrofitAPI
import com.mgssoftware.mgsdashboard.data.remote.RetrofitClient
import com.mgssoftware.mgsdashboard.databinding.FragmentAvfastBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AvfastFragment : BaseFragment<FragmentAvfastBinding>(FragmentAvfastBinding::inflate) {

//    private val viewModel: AvfastFragmentViewModel by viewModels()

    private val retrofit = RetrofitClient.getRetrofitClient()
    private val apiService = retrofit.create(RetrofitAPI::class.java)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val callAvfast = apiService.getAvfastUser()
        callAvfast.enqueue(object : Callback<AvfastAPI> {
            override fun onResponse(call: Call<AvfastAPI>, response: Response<AvfastAPI>) {
                val body = response.body()!!
                val dataLog: List<Log> = body.logs
                val dataRegistrants: List<RegisterUser> = body.registerUsers
                if (response.isSuccessful) {
                    binding.numberOfUsers.text = body.usersCount.toString()
                    binding.numberOfPeopleOnline.text = body.onlineUsersCount.toString()
                    binding.rvAssignment!!.adapter = AvfastAssignmentAdapter(dataLog)
                    binding.rvRegistrants!!.adapter = AvfastRegistrantsAdapter(dataRegistrants)
                }
            }

            override fun onFailure(call: Call<AvfastAPI>, t: Throwable) {
                Toast.makeText(requireContext(), "exception", Toast.LENGTH_SHORT).show()
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
        configureGraphicRecyclerView()
        addIndicator()
        configureRegistrantsRecyclerView()
        configureAssignmentRecyclerView()
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

    private fun configureGraphicRecyclerView() {
        val list = listOf(
            "BU AY KAYITLI KULLANICI", "Günlük Giriş", "Yeni Task",
            "Başvurma", "Tamamlanan", "Değerlendirme"
        )
        val descriptionList = listOf("10", "10", "9", "7", "3", "3")
        val barBottomValue = arrayListOf("0", "1", "2", "3", "4", "5")

        val barEntry = arrayListOf<BarEntry>()

        barEntry.add(BarEntry(1f, 100f))
        barEntry.add(BarEntry(2f, 250f))
        barEntry.add(BarEntry(3f, 300f))
        barEntry.add(BarEntry(4f, 400f))
        barEntry.add(BarEntry(5f, 400f))

        val barEntry2 = arrayListOf<BarEntry>()

        barEntry2.add(BarEntry(1f, 300f))
        barEntry2.add(BarEntry(2f, 250f))
        barEntry2.add(BarEntry(3f, 200f))
        barEntry2.add(BarEntry(4f, 350f))
        barEntry2.add(BarEntry(5f, 170f))
        barEntry2.add(BarEntry(6f, 100f))


        val barDataSet = BarDataSet(barEntry, "")
        val barDataSet2 = BarDataSet(barEntry2, "")
        barDataSet.color = ContextCompat.getColor(
            requireContext(),
            R.color.graphic_orange
        )
        barDataSet2.color = ContextCompat.getColor(
            requireContext(),
            R.color.graphic_orange
        )

        val barData = BarData(barDataSet)
        val barData2 = BarData(barDataSet2)
        barData.setDrawValues(false)
        barData2.setDrawValues(false)
        barData.barWidth = 0.75f
        barData2.barWidth = 0.75f

        val valueList = arrayListOf<BarData>()
        repeat(3) {
            valueList.add(barData)
        }
        repeat(3) {
            valueList.add(barData2)
        }
        val adapter = AvfastGraphicAdapter(list, descriptionList, barBottomValue, valueList)
        binding.rvGraphicAvfast.setHasFixedSize(true)
        binding.rvGraphicAvfast.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvGraphicAvfast.adapter = adapter
    }

    private fun addIndicator() {
        binding.arIndicator?.attachTo(binding.rvGraphicAvfast, true)
    }

}


