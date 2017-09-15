package com.github.iamwee.kotlinmvpstructure.view.main.presenter

import com.github.iamwee.kotlinmvpstructure.ServiceCallback
import com.github.iamwee.kotlinmvpstructure.base.presenter.BasePresenter
import com.github.iamwee.kotlinmvpstructure.http.dao.RepoResponse
import retrofit2.Call

/**
 * Created by zeon on 8/24/2017 AD.
 */

class MainPresenter(repository: MainRepository, view: IMainView) : BasePresenter<MainRepository, IMainView>(repository, view), IMainPresenter {

    override fun getRepositoryFromGithub() {
        repository.getRepositories(object : ServiceCallback<List<RepoResponse>> {
            override fun onResponse(call: Call<List<RepoResponse>>, body: List<RepoResponse>) {
                view.onRepoResult(body)
            }

            override fun onFailure(call: Call<List<RepoResponse>>, t: Throwable) {

            }

        })
    }

}
