package com.github.iamwee.kotlinmvpstructure.common

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View

/**
 * Created by zeon on 8/25/2017 AD.
 */

class BundleSavedState : View.BaseSavedState {

    var bundle: Bundle = Bundle()

    constructor(source: Parcel) : super(source) {
        bundle = source.readBundle(javaClass.classLoader)
    }

    constructor(superState: Parcelable) : super(superState)


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)
        parcel.writeBundle(bundle)
    }

    companion object CREATOR : Parcelable.Creator<BundleSavedState> {
        override fun createFromParcel(parcel: Parcel): BundleSavedState = BundleSavedState(parcel)

        override fun newArray(size: Int): Array<BundleSavedState?> = arrayOfNulls(size)
    }
}
