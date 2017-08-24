package com.github.iamwee.kotlinmvpstructure.view.main.presenter

import com.github.iamwee.kotlinmvpstructure.ServiceCallback
import com.github.iamwee.kotlinmvpstructure.base.presenter.BaseRepository
import com.github.iamwee.kotlinmvpstructure.http.HttpProvider
import com.github.iamwee.kotlinmvpstructure.http.dao.RepoResponse
import retrofit2.Call

/**
 * Created by zeon on 8/24/2017 AD.
 */

class MainRepository : BaseRepository() {

    fun getRepositories(callback: ServiceCallback<List<RepoResponse>>) {
        call(HttpProvider.instance.githubService().getRepositories(), false, object : ServiceCallback<List<RepoResponse>> {
            override fun onResponse(call: Call<List<RepoResponse>>?, body: List<RepoResponse>?) {
                callback.onResponse(call, body)
            }

            override fun onFailure(call: Call<List<RepoResponse>>?, t: Throwable?) {
                callback.onFailure(call, t)
            }
        })
    }

}
