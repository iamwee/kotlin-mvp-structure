package com.github.iamwee.kotlinmvpstructure.extensions

import android.support.v4.app.Fragment
import android.widget.Toast

/**
 * Created by zeon on 9/11/2017 AD.
 */

fun Fragment.showToast(message : String) {
    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
}