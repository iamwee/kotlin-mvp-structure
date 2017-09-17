package com.github.iamwee.kotlinmvpstructure.http

import com.github.iamwee.kotlinmvpstructure.BuildConfig
import com.github.iamwee.kotlinmvpstructure.http.service.GithubService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by zeon on 8/24/2017 AD.
 */

class HttpProvider {

    private val TIMEOUT: Long = 10

    companion object {
        val instance by lazy { HttpProvider() }
    }

    fun githubService(): GithubService = retrofit().create(GithubService::class.java)

    private fun retrofit(): Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_SERVICE)
            .client(httpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private fun httpClient(): OkHttpClient = OkHttpClient.Builder()
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
            .build()
}