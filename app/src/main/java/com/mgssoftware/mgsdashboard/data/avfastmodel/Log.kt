package com.mgssoftware.mgsdashboard.data.avfastmodel


import com.google.gson.annotations.SerializedName

data class Log(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("description")
    val description: String? = null
)