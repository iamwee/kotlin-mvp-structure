package com.github.iamwee.kotlinmvpstructure.base

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.github.iamwee.kotlinmvpstructure.ServiceCallback
import com.github.iamwee.kotlinmvpstructure.base.presenter.BasePresenter
import com.github.iamwee.kotlinmvpstructure.base.presenter.IBasePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by zeon on 8/24/2017 AD.
 */

abstract class BaseFragment<PRESENTER : IBasePresenter> : Fragment() {

    lateinit var presenter: PRESENTER

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = onCreatePresenter()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    protected abstract fun setupView()
    protected abstract fun onCreatePresenter(): PRESENTER
}
