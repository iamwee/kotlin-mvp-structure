package com.github.iamwee.kotlinmvpstructure.base.presenter


import kotlin.properties.Delegates

/**
 * Created by zeon on 8/24/2017 AD.
 */

@Suppress("LeakingThis")
abstract class BasePresenter<out View : IBaseView<ViewModel>, ViewModel : Any>(val view: View) {

    var viewModel by Delegates.observable(onCreateViewModel(), { _, _, newViewModel ->
        view.onViewModelChanged(newViewModel)
    })

    abstract fun onCreateViewModel(): ViewModel
}
