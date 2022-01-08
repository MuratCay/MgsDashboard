package com.mgssoftware.mgsdashboard.adapters.petneradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.adapters.petneradapter.petnerviewholder.PetnerGraphicViewHolder
import com.mgssoftware.mgsdashboard.data.petnermodel.PetnerAPI
import com.mgssoftware.mgsdashboard.databinding.ItemPetnerGraphicBinding
import com.mgssoftware.mgsdashboard.ui.fragment.petner.PetnerEnum

class PetnerGraphicAdapter(
    private val graphicsTitle: List<String>,
    private val apiData: PetnerAPI
) : RecyclerView.Adapter<PetnerGraphicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetnerGraphicViewHolder {
        val view =
            ItemPetnerGraphicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PetnerGraphicViewHolder(view)
    }

    override fun onBindViewHolder(holder: PetnerGraphicViewHolder, position: Int) {
        holder.setPetnerGraphTitle(graphicsTitle[position])

        when (position) {
            PetnerEnum.KAYITLI_KULLANICI.ordinal -> holder.usersInLastFiveMonthsChart(
                apiData.usersInLastFiveMonthsChart,
                apiData.usersInLastMonthCount
            )
            PetnerEnum.GUNLUK_GIRIS.ordinal -> holder.usersLoggedInLastWeekChart(
                apiData.usersLoggedLnLastWeekChart,
                apiData.usersLoggedLnTodayCount
            )
            PetnerEnum.YENI_POST.ordinal -> holder.postsInLastFiveMonthsChart(
                apiData.postsInLastFiveMonthsChart,
                apiData.postsInLastMonthCount
            )
            PetnerEnum.CHAT_SAYISI.ordinal -> holder.conversationsInLastFiveWeeksChart(
                apiData.conversationsInLastFiveWeeksChart,
                apiData.conversationsInLastWeekCount
            )
            PetnerEnum.POST_YORUM.ordinal -> holder.commentsInLastFiveMonthsChart(
                apiData.commentsInLastFiveMonthsChart,
                apiData.commentsInLastMonthCount
            )
        }
    }

    override fun getItemCount() = graphicsTitle.size
}