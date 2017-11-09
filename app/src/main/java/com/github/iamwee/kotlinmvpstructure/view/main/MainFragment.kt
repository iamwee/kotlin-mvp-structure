package com.github.iamwee.kotlinmvpstructure.view.main

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.github.iamwee.kotlinmvpstructure.R
import com.github.iamwee.kotlinmvpstructure.base.presenter.MvpFragment
import com.github.iamwee.kotlinmvpstructure.extensions.showToast
import com.github.iamwee.kotlinmvpstructure.http.entity.RepositoryEntity
import com.github.iamwee.kotlinmvpstructure.view.main.adapter.MainAdapter
import com.github.iamwee.kotlinmvpstructure.view.main.presenter.IMainPresenter
import com.github.iamwee.kotlinmvpstructure.view.main.presenter.IMainView
import com.github.iamwee.kotlinmvpstructure.view.main.presenter.MainPresenter
import com.github.iamwee.kotlinmvpstructure.view.main.presenter.MainRepository
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : MvpFragment<IMainPresenter>(), IMainView {

    companion object {
        fun newInstance(): MainFragment = MainFragment().apply {
            arguments = Bundle()
        }
    }

    private lateinit var mainAdapter: MainAdapter
    override var layoutId: Int = R.layout.fragment_main

    override fun onCreatePresenter(): IMainPresenter = MainPresenter(MainRepository(), this)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainAdapter = MainAdapter().apply {
            listener = { position -> showToast("Action from position $position") }
        }

        with(recyclerView) {
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
            adapter = mainAdapter
        }
    }

    override fun onRepoSuccess(entities: List<RepositoryEntity>) = mainAdapter.map(entities)
}