package com.noqok.a90plus_quiz.services

import com.noqok.a90plus_quiz.models.Team
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FootballApiService {

    @GET("v4/teams/{id}")
    suspend fun getTeamById(
        @Path("id") teamId: Int,
        @Header("X-Auth-Token") apiKey: String
    ): Response<Team>
}
