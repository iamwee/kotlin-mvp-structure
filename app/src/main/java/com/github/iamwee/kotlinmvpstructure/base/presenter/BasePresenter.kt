package com.github.iamwee.kotlinmvpstructure.base.presenter

/**
 * Created by zeon on 8/24/2017 AD.
 */

open class BasePresenter<out REPOSITORY : MvpRepository, out VIEW : IBaseView>(val repository: REPOSITORY, val view: VIEW)
