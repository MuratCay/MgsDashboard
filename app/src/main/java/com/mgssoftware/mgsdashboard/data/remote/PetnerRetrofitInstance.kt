package com.mgssoftware.mgsdashboard.data.remote

import com.mgssoftware.mgsdashboard.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class PetnerRetrofitClient {
    companion object {
        @Volatile
        private var INSTANCE: Retrofit? = null

        fun getPetnerRetrofitClient(): Retrofit {
            return INSTANCE ?: synchronized(this) {
                val instance = Retrofit.Builder()
                    .baseUrl(Constants.PETNER_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}