package com.github.iamwee.kotlinmvpstructure.view.main.presenter


import com.github.iamwee.kotlinmvpstructure.extensions.enquene
import com.github.iamwee.kotlinmvpstructure.http.HttpProvider
import com.github.iamwee.kotlinmvpstructure.http.entity.RepositoryEntity

/**
 * Created by zeon on 8/24/2017 AD.
 */

class MainRepository {

    private val service = HttpProvider.instance.githubService

    fun getRepositories(success: (List<RepositoryEntity>) -> Unit, failure: (String) -> Unit) {
        service.getRepositories().enquene({ response ->
            if (response.isSuccessful) {
                success(response.body()!!)
            }
        }, { throwable -> failure(throwable.localizedMessage) })
    }
}
