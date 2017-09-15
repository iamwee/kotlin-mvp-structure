package com.github.iamwee.kotlinmvpstructure.base.presenter

import com.github.iamwee.kotlinmvpstructure.ServiceCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class BaseRepository {

    protected fun <ResponseBody> call(service: Call<ResponseBody>, callback: ServiceCallback<ResponseBody>) {
        service.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    callback.onResponse(call, response.body()!!)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                t.printStackTrace()
                callback.onFailure(call, t)
            }
        })
    }
}
