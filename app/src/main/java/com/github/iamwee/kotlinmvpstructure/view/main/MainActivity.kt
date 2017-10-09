package com.github.iamwee.kotlinmvpstructure.view.main

import android.os.Bundle
import com.github.iamwee.kotlinmvpstructure.R
import com.github.iamwee.kotlinmvpstructure.base.BaseActivity
import com.github.iamwee.kotlinmvpstructure.extensions.add

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainFragment.newInstance().add(supportFragmentManager, savedInstanceState)
    }
}
