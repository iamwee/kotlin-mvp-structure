package com.github.iamwee.kotlinmvpstructure.base.presenter


/**
 * Created by zeon on 8/24/2017 AD.
 */

interface IBaseView<in ViewModel: Any> {

    fun onViewModelChanged(viewModel: ViewModel)
}
