package com.noqok.a90plus_quiz.app

import android.app.Application
import com.noqok.a90plus_quiz.repositories.ApiRepository

class MyApplication : Application() {

    lateinit var apiRepository: ApiRepository

    override fun onCreate() {
        super.onCreate()
        apiRepository = ApiRepository("1dc6a8038f804c579ad9ab40cdb12b4f")
    }
}
