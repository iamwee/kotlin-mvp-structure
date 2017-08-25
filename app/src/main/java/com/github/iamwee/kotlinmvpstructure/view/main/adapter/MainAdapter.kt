package com.github.iamwee.kotlinmvpstructure.view.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.iamwee.kotlinmvpstructure.R
import com.github.iamwee.kotlinmvpstructure.http.dao.RepoResponse

/**
 * Created by zeon on 8/24/2017 AD.
 */

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var listener: ((Int) -> Unit)? = null

    var items: List<RepoResponse> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder? = ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.tvTitle.text = """
                |${items[position].name}
                |${items[position].fullName}
                |${items[position].url}
                """.trimMargin()
            holder.itemView.setOnClickListener {
                listener?.invoke(position)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    private class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
    }
}
