package com.github.iamwee.kotlinmvpstructure.view.main.presenter

import com.github.iamwee.kotlinmvpstructure.base.presenter.BasePresenter

/**
 * Created by zeon on 8/24/2017 AD.
 */

class MainPresenter(repository: MainRepository, view: IMainView)
    : BasePresenter<MainRepository, IMainView>(repository, view), IMainPresenter {

    init {
        getRepositoryFromGithub()
    }

    override fun getRepositoryFromGithub() {
        repository.getRepositories({ data -> view.onRepoSuccess(data) }, {})
    }

}
