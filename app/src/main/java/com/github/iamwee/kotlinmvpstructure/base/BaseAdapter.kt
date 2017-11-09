package com.github.iamwee.kotlinmvpstructure.base

import android.support.v7.widget.RecyclerView
import kotlin.properties.Delegates

/**
 * Created by zeon on 9/15/2017 AD.
 */

abstract class BaseAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    open var items by Delegates.observable(listOf<BaseItem>(), { _, _, _ ->
        notifyDataSetChanged()
    })

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = items[position].type
}
