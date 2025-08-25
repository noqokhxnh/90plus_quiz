package com.noqok.a90plus_quiz.models

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("crest")
    val crestUrl: String?,
    @SerializedName("squad")
    val squad: List<Player> = emptyList()
)
