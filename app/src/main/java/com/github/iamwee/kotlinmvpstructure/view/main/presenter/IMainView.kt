package com.github.iamwee.kotlinmvpstructure.view.main.presenter

import com.github.iamwee.kotlinmvpstructure.base.presenter.IBaseView
import com.github.iamwee.kotlinmvpstructure.http.entity.RepositoryEntity

/**
 * Created by zeon on 8/24/2017 AD.
 */

interface IMainView : IBaseView {

    fun onRepoSuccess(entities: List<RepositoryEntity>)

}
