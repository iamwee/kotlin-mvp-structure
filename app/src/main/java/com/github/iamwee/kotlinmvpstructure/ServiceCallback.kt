package com.github.iamwee.kotlinmvpstructure

import retrofit2.Call


interface ServiceCallback<T> {

    fun onResponse(call: Call<T>, body: T)

    fun onFailure(call: Call<T>, t: Throwable)
}
