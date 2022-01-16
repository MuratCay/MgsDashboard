package com.mgssoftware.mgsdashboard.petner.data.model


import com.google.gson.annotations.SerializedName

data class Log(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("description")
    val description: String? = null
)