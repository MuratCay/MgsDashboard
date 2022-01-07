package com.mgssoftware.mgsdashboard.ui.fragment.avfast

import android.os.Bundle
import android.view.View
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
import com.mgssoftware.mgsdashboard.data.avfastmodel.*
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

    private var dataMonthlyTotalUsersChart: List<MonthlyTotalUsersChart?>? = null
    private var dataDailyLoggedInUsersChart: List<DailyLoggedInUsersChart?>? = null
    private var dataDailyLoggedInUsersCount: Int? = null

    private var dataMonthlyTotalUsersCount: Int? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureGraphicRecyclerView()
        addIndicator()
        configureRegistrantsRecyclerView()
        configureAssignmentRecyclerView()

        val callAvfast = apiService.getAvfastUser()
        callAvfast.enqueue(object : Callback<AvfastAPI> {
            override fun onResponse(call: Call<AvfastAPI>, response: Response<AvfastAPI>) {

                val body = response.body()!!

                val dataLog: List<Log?>? = body.logs
                val dataRegistrants: List<RegisterUser?>? = body.registerUsers
                dataMonthlyTotalUsersChart = body.monthlyTotalUsersChart

                dataDailyLoggedInUsersCount = body.dailyLoggedInUsersCount
                dataDailyLoggedInUsersChart = body.dailyLoggedInUsersChart

                dataMonthlyTotalUsersCount = body.monthlyTotalUsersCount

                val dataWeeklyTasksCount: Int? = body.weeklyTasksCount
                val dataWeeklyTasksChart: List<WeeklyTasksChart?>? = body.weeklyTasksChart


                val dataWeeklyAppliedTasksCount: Int? = body.weeklyAppliedTasksCount
                val dataWeeklyAppliedTasksChart: List<WeeklyAppliedTasksChart?>? =
                    body.weeklyAppliedTasksChart

                val dataWeeklyEvaluatedTasksCount: Int? = body.weeklyEvaluatedTasksCount
                val dataWeeklyEvaluatedTasksChart: List<WeeklyEvaluatedTasksChart?>? =
                    body.weeklyEvaluatedTasksChart

                val dataWeeklyDoneTasksCount: Int? = body.weeklyDoneTasksCount
                val dataWeeklyDoneTasksChart: List<WeeklyDoneTasksChart?>? =
                    body.weeklyDoneTasksChart


                if (response.isSuccessful) {
                    binding.numberOfUsers.text = body.usersCount.toString()
                    binding.numberOfPeopleOnline.text = body.onlineUsersCount.toString()
                    binding.rvAssignment!!.adapter = AvfastAssignmentAdapter(dataLog)
                    binding.rvRegistrants!!.adapter = AvfastRegistrantsAdapter(dataRegistrants)
                    updateAvfastRecycler()
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
        val descriptionList = arrayListOf<String>()
        val barBottomValue = arrayListOf<String>()

        val barEntry = arrayListOf<BarEntry>()
        for (i in dataMonthlyTotalUsersChart!!.indices) {
            barEntry.add(
                BarEntry(
                    i.toFloat(),
                    dataMonthlyTotalUsersChart!![i]!!.usersCount!!.toFloat()
                )
            )
            barBottomValue.add(dataMonthlyTotalUsersChart!![0]!!.createdAt!!.toString())
//            descriptionList.add(dataMonthlyTotalUsersCount.toString())
        }

        /**
        for (i in dataDailyLoggedInUsersChart!!.indices){
        barEntry.add(BarEntry(i.toFloat(),dataDailyLoggedInUsersChart!![i]!!.usersCount!!.toFloat()))
        barBottomValue.add(dataDailyLoggedInUsersChart!![i]!!.day!!.toString())
        }
         */

        val barDataSet = BarDataSet(barEntry, "")
        barDataSet.color = ContextCompat.getColor(
            requireContext(),
            R.color.graphic_orange
        )

        val barData = BarData(barDataSet)
        barData.setDrawValues(false)
        barData.barWidth = 0.75f

        val valueList = arrayListOf<BarData>()
        repeat(6) {
            valueList.add(barData)
        }

        val adapter = AvfastGraphicAdapter(list, descriptionList, barBottomValue, valueList)
        binding.rvGraphicAvfast.setHasFixedSize(true)
        binding.rvGraphicAvfast.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvGraphicAvfast.adapter = adapter
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


        val barDataSet = BarDataSet(barEntry, "")
        barDataSet.color = ContextCompat.getColor(
            requireContext(),
            R.color.graphic_orange
        )

        val barData = BarData(barDataSet)
        barData.setDrawValues(false)
        barData.barWidth = 0.75f

        val valueList = arrayListOf<BarData>()
        repeat(6) {
            valueList.add(barData)
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


