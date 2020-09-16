package com.example.xfit.network

import com.example.xfit.data.WorkoutType
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface NetworkService {

    @GET("ed06f3e422b87ae8419ae7754203356b/raw/672c66a452d9ab12f90e62f0ef3ebd5922aa1b00/workoutType")
    suspend fun getWorkout(): List<WorkoutType>

    @GET("ed06f3e422b87ae8419ae7754203356b/raw/0f9a23693c47d9ef6242945fe4e0c277d98e80d9/workoutType")
    suspend fun getArmWorkout(): List<WorkoutType>

    /** add interceptor to generate logs request and response information*/
    companion object {
        private const val BASE_URL = "https://gist.githubusercontent.com/Aliendroid8045/"

        fun createNetworkService(): NetworkService {
            val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            }
            val client: OkHttpClient = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .apply {
                    this.addInterceptor(interceptor)
                }.build()

            /** Build retrofit client*/
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build().create(NetworkService::class.java)
        }
    }
}
