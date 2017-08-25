package com.github.iamwee.kotlinmvpstructure.http.dao

import com.google.gson.annotations.SerializedName

/**
 * Created by zeon on 8/24/2017 AD.
 */

data class Owner(@SerializedName("login") var login: String,
                 @SerializedName("id") var id: Int,
                 @SerializedName("avatar_url") var avatarUrl: String)
