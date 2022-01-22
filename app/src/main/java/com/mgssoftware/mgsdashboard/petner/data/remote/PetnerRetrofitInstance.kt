package com.mgssoftware.mgsdashboard.petner.data.remote

import com.mgssoftware.mgsdashboard.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class PetnerRetrofitClient {
    companion object {
        @Volatile
        private var INSTANCE: Retrofit? = null

        fun getPetnerRetrofitClient(): Retrofit {
            return INSTANCE ?: synchronized(this) {
                val instance = Retrofit.Builder()
                    .baseUrl(Constants.PETNER_BASE_URL)
                    .client(clientSetup)
                    .addConverterFactory(GsonConverterFactory.create())
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