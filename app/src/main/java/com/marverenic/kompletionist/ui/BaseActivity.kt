package com.marverenic.kompletionist.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(canNavigateUp())
            setHomeButtonEnabled(canNavigateUp())
            setDisplayShowHomeEnabled(canNavigateUp())
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    abstract fun canNavigateUp(): Boolean

}