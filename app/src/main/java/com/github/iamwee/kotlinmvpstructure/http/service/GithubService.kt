package com.github.iamwee.kotlinmvpstructure.http.service

import com.github.iamwee.kotlinmvpstructure.http.entity.RepositoryEntity
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by zeon on 8/24/2017 AD.
 */

interface GithubService {

    @GET("/users/iamwee/repos")
    fun getRepositories(): Call<List<RepositoryEntity>>
}
