package com.noqok.a90plus_quiz.repositories

import com.noqok.a90plus_quiz.services.FootballApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRepository(private val apiKey: String) {

    private val footballApiService: FootballApiService

    init {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.football-data.org/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        footballApiService = retrofit.create(FootballApiService::class.java)
    }

    suspend fun getTeamById(teamId: Int) = footballApiService.getTeamById(teamId, apiKey)
}