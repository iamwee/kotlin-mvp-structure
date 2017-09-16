package com.github.iamwee.kotlinmvpstructure.view.main.adapter

import android.view.ViewGroup
import android.widget.TextView
import com.github.iamwee.kotlinmvpstructure.R
import com.github.iamwee.kotlinmvpstructure.base.BaseAdapter
import com.github.iamwee.kotlinmvpstructure.base.BaseItem
import com.github.iamwee.kotlinmvpstructure.base.BaseViewHolder
import com.github.iamwee.kotlinmvpstructure.common.ViewTypeNotFoundException
import com.github.iamwee.kotlinmvpstructure.http.dao.RepoResponse

/**
 * Created by zeon on 8/24/2017 AD.
 */

class MainAdapter : BaseAdapter() {

    companion object {
        val TYPE_REPO = 1
    }

    var listener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        when (viewType) {
            TYPE_REPO -> return ItemViewHolder(parent)
        }
        throw ViewTypeNotFoundException(viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            val item = items[position] as RepoItem
            holder.tvTitle.text = item.content
            holder.itemView.setOnClickListener {
                listener?.invoke(position)
            }
        }
    }

    fun map(datas: List<RepoResponse>) {
        val baseItems = ArrayList<BaseItem>()
        for ((_, name, fullName, _, url) in datas) {
            baseItems.add(RepoItem("""
                |$name
                |$fullName
                |$url
                """.trimMargin()))
        }
        items = baseItems
        notifyDataSetChanged()
    }

    private class ItemViewHolder(parent: ViewGroup) : BaseViewHolder(parent, R.layout.item_main) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
    }
}
