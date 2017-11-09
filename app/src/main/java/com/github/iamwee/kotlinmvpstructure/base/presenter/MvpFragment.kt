package com.github.iamwee.kotlinmvpstructure.base.presenter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.iamwee.kotlinmvpstructure.base.BaseFragment

/**
 * Created by zeon on 8/24/2017 AD.
 */

abstract class MvpFragment<PRESENTER : IBasePresenter> : BaseFragment() {

    lateinit var presenter: PRESENTER
    protected abstract var layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = onCreatePresenter()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? = inflater?.inflate(layoutId, container, false)

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    protected abstract fun onCreatePresenter(): PRESENTER
}
