package com.github.iamwee.kotlinmvpstructure.extensions

import android.os.Bundle
import com.github.iamwee.kotlinmvpstructure.R
import com.github.iamwee.kotlinmvpstructure.base.BaseActivity
import com.github.iamwee.kotlinmvpstructure.base.BaseFragment

/**
 * Created by zeon on 10/9/2017 AD.
 */

@JvmOverloads
fun BaseActivity.addFragment(fragment: BaseFragment,
                             savedInstanceState: Bundle? = null,
                             layoutId: Int = R.id.container) {
    if (savedInstanceState == null) {
        try {
            supportFragmentManager.beginTransaction()
                    .add(layoutId, fragment)
                    .commit()
        } catch (e: IllegalStateException) {
            supportFragmentManager.beginTransaction()
                    .add(layoutId, fragment)
                    .commitAllowingStateLoss()
        }
    }
}

@JvmOverloads
fun BaseActivity.replaceFragment(fragment: BaseFragment,
                                 savedInstanceState: Bundle? = null,
                                 layoutId: Int = R.id.container) {
    if (savedInstanceState == null) {
        try {
            supportFragmentManager.beginTransaction()
                    .replace(layoutId, fragment)
                    .commit()
        } catch (e: IllegalStateException) {
            supportFragmentManager.beginTransaction()
                    .replace(layoutId, fragment)
                    .commitAllowingStateLoss()
        }
    }
}