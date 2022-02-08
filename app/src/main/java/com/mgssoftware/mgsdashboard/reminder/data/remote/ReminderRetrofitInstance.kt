package com.mgssoftware.mgsdashboard.reminder.data.remote

import com.mgssoftware.mgsdashboard.utils.Constants.REMINDER_BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class ReminderRetrofitClient {
    companion object {
        @Volatile
        private var INSTANCE: Retrofit? = null

        fun getReminderRetrofitClient(): Retrofit {
            return INSTANCE ?: synchronized(this) {
                val instance = Retrofit.Builder()
                    .baseUrl(REMINDER_BASE_URL)
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
    .connectTimeout(2, TimeUnit.MINUTES)
    .writeTimeout(2, TimeUnit.MINUTES) // write timeout
    .readTimeout(2, TimeUnit.MINUTES) // read timeout
    .build()