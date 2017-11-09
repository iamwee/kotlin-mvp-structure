package com.github.iamwee.kotlinmvpstructure.view.main.presenter

import com.github.iamwee.kotlinmvpstructure.base.presenter.MvpRepository
import com.github.iamwee.kotlinmvpstructure.extensions.enquene
import com.github.iamwee.kotlinmvpstructure.http.HttpProvider
import com.github.iamwee.kotlinmvpstructure.http.entity.RepositoryEntity
import retrofit2.Call

/**
 * Created by zeon on 8/24/2017 AD.
 */

class MainRepository : MvpRepository() {

    fun getRepositories(success: (List<RepositoryEntity>) -> Unit, failure: (String) -> Unit) {
        repositoriesCall().enquene({ response ->
            if (response.isSuccessful) {
                success(response.body()!!)
            }
        }, { throwable -> failure(throwable.localizedMessage) })
    }

    private fun repositoriesCall(): Call<List<RepositoryEntity>> = HttpProvider.instance.githubService.getRepositories()

}
