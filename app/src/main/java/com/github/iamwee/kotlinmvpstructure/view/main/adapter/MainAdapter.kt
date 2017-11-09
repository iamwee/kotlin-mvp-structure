package com.github.iamwee.kotlinmvpstructure.view.main.adapter

import android.view.ViewGroup
import com.github.iamwee.kotlinmvpstructure.R
import com.github.iamwee.kotlinmvpstructure.base.BaseAdapter
import com.github.iamwee.kotlinmvpstructure.base.BaseItem
import com.github.iamwee.kotlinmvpstructure.base.BaseViewHolder
import com.github.iamwee.kotlinmvpstructure.common.ViewTypeNotFoundException
import com.github.iamwee.kotlinmvpstructure.http.entity.RepositoryEntity
import kotlinx.android.synthetic.main.item_main.view.*

/**
 * Created by zeon on 8/24/2017 AD.
 */

class MainAdapter : BaseAdapter() {

    companion object {
        const val TYPE_REPO = 1
    }

    lateinit var listener: (Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder = when (viewType) {
        TYPE_REPO -> ItemViewHolder(parent)
        else -> throw ViewTypeNotFoundException(viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            val item = items[position] as RepoItem
            with(holder.itemView) {
                tvTitle.text = item.content
                setOnClickListener {
                    listener(position)
                }
            }
        }
    }

    fun map(response: List<RepositoryEntity>) {
        val baseItems = ArrayList<BaseItem>()
        for ((_, name, fullName, _, url) in response) {
            baseItems.add(RepoItem("""
                |$name
                |$fullName
                |$url
                """.trimMargin()))
        }
        items = baseItems
    }

    private class ItemViewHolder(parent: ViewGroup) : BaseViewHolder(parent, R.layout.item_main)
}
