package com.github.iamwee.kotlinmvpstructure.base

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by zeon on 9/15/2017 AD.
 */
abstract class BaseViewHolder(parent: ViewGroup?, layoutId: Int) : RecyclerView.ViewHolder(LayoutInflater.from(parent?.context).inflate(layoutId, parent, false))
