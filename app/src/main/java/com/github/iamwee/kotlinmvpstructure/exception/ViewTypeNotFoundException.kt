package com.github.iamwee.kotlinmvpstructure.exception

/**
 * Created by zeon on 9/15/2017 AD.
 */

class ViewTypeNotFoundException(viewType: Int)
    : NullPointerException("viewType $viewType isn't match for this adapter")
