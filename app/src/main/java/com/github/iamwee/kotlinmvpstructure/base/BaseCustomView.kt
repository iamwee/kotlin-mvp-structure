package com.github.iamwee.kotlinmvpstructure.base

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.support.annotation.AttrRes
import android.support.annotation.StyleRes
import android.util.AttributeSet
import android.widget.FrameLayout
import android.os.Parcelable
import android.util.SparseArray
import android.os.Bundle
import com.github.iamwee.kotlinmvpstructure.common.BundleSavedState


/**
 * Created by zeon on 8/25/2017 AD.
 */

abstract class BaseCustomView : FrameLayout {

    private val KEY_CHILDREN_STATES = "children_states"

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
        initStyleable(attrs, 0, 0)
    }

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
        initStyleable(attrs, defStyleAttr, 0)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int, @StyleRes defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init()
        initStyleable(attrs, defStyleAttr, defStyleRes)
    }

    protected abstract fun init()
    protected abstract fun initStyleable(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int)

    override fun onSaveInstanceState(): Parcelable {
        val superState = super.onSaveInstanceState()

        val childrenStates = Bundle()
        for (i in 0 until childCount - 1) {
            val id = getChildAt(i).id
            if (id != 0) {
                val childrenState = SparseArray<Parcelable>()
                getChildAt(i).saveHierarchyState(childrenState)
                childrenStates.putSparseParcelableArray(id.toString(), childrenState)
            }
        }

        val ss = BundleSavedState(superState)
        ss.bundle.putBundle(KEY_CHILDREN_STATES, childrenStates)
        return ss
    }

    override fun onRestoreInstanceState(state: Parcelable) {
        val ss = state as BundleSavedState
        super.onRestoreInstanceState(ss.superState)

        val childrenStates = ss.bundle.getBundle(KEY_CHILDREN_STATES)
        for (i in 0 until childCount - 1) {
            val id = getChildAt(i).id
            if (id != 0) {
                if (childrenStates.containsKey(id.toString())) {
                    val childrenState = childrenStates.getSparseParcelableArray<Parcelable>(id.toString())
                    getChildAt(i).restoreHierarchyState(childrenState)
                }
            }
        }
    }

    override fun dispatchSaveInstanceState(container: SparseArray<Parcelable>) {
        dispatchFreezeSelfOnly(container)
    }

    override fun dispatchRestoreInstanceState(container: SparseArray<Parcelable>) {
        dispatchThawSelfOnly(container)
    }
}