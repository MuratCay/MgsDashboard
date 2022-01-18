package com.mgssoftware.mgsdashboard.redminer.data.remote

import com.mgssoftware.mgsdashboard.utils.Constants.REDMINER_BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class RedminerRetrofitClient {
    companion object {
        @Volatile
        private var INSTANCE: Retrofit? = null

        fun getRedminerRetrofitClient(): Retrofit {
            return INSTANCE ?: synchronized(this) {
                val instance = Retrofit.Builder()
                    .baseUrl(REDMINER_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(clientSetup)
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

val clientSetup: OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(5, TimeUnit.MINUTES)
    .writeTimeout(5, TimeUnit.MINUTES) // write timeout
    .readTimeout(5, TimeUnit.MINUTES) // read timeout
    .build()