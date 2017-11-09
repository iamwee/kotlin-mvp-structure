package com.github.iamwee.kotlinmvpstructure.http.entity

import android.os.Parcel
import com.github.iamwee.kotlinmvpstructure.extensions.DataClassParcelable
import com.github.iamwee.kotlinmvpstructure.extensions.parcelableCreator
import com.google.gson.annotations.SerializedName

/**
 * Created by zeon on 8/24/2017 AD.
 */

data class RepositoryEntity(@SerializedName("id") var id: Int,
                            @SerializedName("name") var name: String,
                            @SerializedName("full_name") var fullName: String,
                            @SerializedName("owner") var owner: Owner,
                            @SerializedName("url") var url: String) : DataClassParcelable {



    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(Owner::class.java.classLoader),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) = with(parcel) {
        writeInt(id)
        writeString(name)
        writeString(fullName)
        writeParcelable(owner, flags)
        writeString(url)
    }

    companion object {
        val CREATOR = parcelableCreator(::RepositoryEntity)
    }
}

data class Owner(@SerializedName("login") var login: String,
                 @SerializedName("id") var id: Int,
                 @SerializedName("avatar_url") var avatarUrl: String) : DataClassParcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) = with(parcel) {
        writeString(login)
        writeInt(id)
        writeString(avatarUrl)
    }

    companion object {
        val CREATOR = parcelableCreator(::Owner)
    }
}