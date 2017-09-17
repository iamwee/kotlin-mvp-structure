package com.github.iamwee.kotlinmvpstructure.view.main

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.github.iamwee.kotlinmvpstructure.R
import com.github.iamwee.kotlinmvpstructure.base.BaseFragment
import com.github.iamwee.kotlinmvpstructure.http.dao.RepoResponse
import com.github.iamwee.kotlinmvpstructure.view.main.adapter.MainAdapter
import com.github.iamwee.kotlinmvpstructure.view.main.presenter.IMainPresenter
import com.github.iamwee.kotlinmvpstructure.view.main.presenter.IMainView
import com.github.iamwee.kotlinmvpstructure.view.main.presenter.MainPresenter
import com.github.iamwee.kotlinmvpstructure.view.main.presenter.MainRepository
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment<IMainPresenter>(), IMainView {

    private lateinit var mainAdapter: MainAdapter

    override fun getLayoutId(): Int = R.layout.fragment_main

    override fun onCreatePresenter(): IMainPresenter = MainPresenter(MainRepository(), this)

    override fun setupView() {
        mainAdapter = MainAdapter().apply {
            listener = { position -> Toast.makeText(activity, "Action from position $position", Toast.LENGTH_SHORT).show() }
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
            adapter = mainAdapter
        }

        presenter.getRepositoryFromGithub()
    }

    override fun onRepoResult(result: List<RepoResponse>) {
        mainAdapter.map(result)
    }

    companion object {
        fun newInstance(): MainFragment = MainFragment().apply {
            arguments = Bundle()
        }
    }
}