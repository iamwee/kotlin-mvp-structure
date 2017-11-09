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
import com.github.iamwee.kotlinmvpstructure.view.main.presenter.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : MvpFragment<IMainPresenter>(), IMainView<MainViewModel> {

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }

    private val mainAdapter = MainAdapter()
    override var layoutId: Int = R.layout.fragment_main

    override fun onCreatePresenter(): IMainPresenter = MainPresenter(this)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainAdapter.apply {
            listener = { position -> showToast("Action from position $position") }
        }

        swipeRefreshLayout.setOnRefreshListener { presenter.getRepositoryFromGithub() }

        with(recyclerView) {
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
            adapter = mainAdapter
        }
    }

    override fun onViewModelChanged(viewModel: MainViewModel) {
        with(viewModel) {
            swipeRefreshLayout.isRefreshing = loading
            mainAdapter.map(repositoryEntities)

            error?.let {
                showToast(viewModel.error!!)
            }
        }
    }
}