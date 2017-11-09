package com.github.iamwee.kotlinmvpstructure.view.main.presenter


import com.github.iamwee.kotlinmvpstructure.http.entity.RepositoryEntity

/**
 * Created by zeon on 9/11/2017 AD.
 */

data class MainViewModel(var loading: Boolean = false,
                    var repositoryEntities: List<RepositoryEntity> = listOf(),
                    var error: String? = null
)