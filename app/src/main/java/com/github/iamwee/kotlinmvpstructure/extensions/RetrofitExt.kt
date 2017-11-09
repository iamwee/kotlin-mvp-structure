package com.github.iamwee.kotlinmvpstructure.extensions

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by zeon on 9/11/2017 AD.
 */

fun <T> Call<T>.enquene(success: (Response<T>) -> Unit, failure: (Throwable) -> Unit) {
    enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) = success(response)
        override fun onFailure(call: Call<T>, t: Throwable) = failure(t)
    })
}