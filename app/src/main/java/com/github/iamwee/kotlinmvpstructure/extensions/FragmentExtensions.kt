package com.github.iamwee.kotlinmvpstructure.extensions

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.github.iamwee.kotlinmvpstructure.R

/**
 * Created by zeon on 10/9/2017 AD.
 */

fun Fragment.add(fragmentManager: FragmentManager, savedInstanceState: Bundle? = null) {
    if (savedInstanceState == null) {
        try {
            fragmentManager.beginTransaction()
                    .add(R.id.container, this)
                    .commit()
        } catch (exception: IllegalStateException) {
            fragmentManager.beginTransaction()
                    .add(R.id.container, this)
                    .commitAllowingStateLoss()
        }
    }
}

fun Fragment.replace(fragmentManager: FragmentManager, savedInstanceState: Bundle? = null) {
    if (savedInstanceState == null) {
        try {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, this)
                    .commit()
        } catch (exception: IllegalStateException) {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, this)
                    .commitAllowingStateLoss()
        }
    }
}