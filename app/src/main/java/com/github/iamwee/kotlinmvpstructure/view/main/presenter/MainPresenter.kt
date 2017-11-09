package com.github.iamwee.kotlinmvpstructure.view.main.presenter

import com.github.iamwee.kotlinmvpstructure.base.presenter.BasePresenter

/**
 * Created by zeon on 8/24/2017 AD.
 */

class MainPresenter(view: IMainView<MainViewModel>) :
        BasePresenter<IMainView<MainViewModel>, MainViewModel>(view), IMainPresenter {

    private val repository = MainRepository()

    override fun onCreateViewModel(): MainViewModel = MainViewModel()

    init {
        getRepositoryFromGithub()
    }

    override fun getRepositoryFromGithub() {
        repository.getRepositories({ data ->
            viewModel = viewModel.copy(loading = false, repositoryEntities = data, error = null)
        }, { error ->
            viewModel = viewModel.copy(loading = false, repositoryEntities = listOf(), error = error)
        })
        viewModel = viewModel.copy(loading = true, repositoryEntities = listOf(), error = null)
    }

}
