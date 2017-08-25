package com.github.iamwee.kotlinmvpstructure.http.dao

import com.google.gson.annotations.SerializedName

/**
 * Created by zeon on 8/24/2017 AD.
 */

data class RepoResponse(@SerializedName("id") var id: Int,
                        @SerializedName("name") var name: String,
                        @SerializedName("full_name") var fullName: String,
                        @SerializedName("owner") var owner: Owner,
                        @SerializedName("url") var url: String)
