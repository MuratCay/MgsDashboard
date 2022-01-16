package com.mgssoftware.mgsdashboard.avfast.data.model


import com.google.gson.annotations.SerializedName

data class Log(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("description")
    val description: String? = null
)