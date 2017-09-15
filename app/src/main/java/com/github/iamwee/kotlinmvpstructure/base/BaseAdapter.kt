package com.github.iamwee.kotlinmvpstructure.base

import android.support.v7.widget.RecyclerView

/**
 * Created by zeon on 9/15/2017 AD.
 */

abstract class BaseAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    var items: List<BaseItem> = ArrayList()

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = items[position].type
}
