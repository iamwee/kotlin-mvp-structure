package com.github.iamwee.kotlinmvpstructure.view.main

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?):
            View? = inflater!!.inflate(R.layout.fragment_main, container, false)

    override fun onCreatePresenter(): IMainPresenter = MainPresenter(MainRepository(), this@MainFragment)

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
        mainAdapter.items = result
        mainAdapter.notifyDataSetChanged()
    }

    companion object {
        fun newInstance(): MainFragment {
            val args = Bundle()
            val fragment = MainFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
