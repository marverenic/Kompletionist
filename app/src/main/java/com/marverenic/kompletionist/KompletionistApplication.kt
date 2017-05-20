package com.marverenic.kompletionist

import android.app.Application
import com.marverenic.kompletionist.inject.ApplicationModule
import com.marverenic.kompletionist.inject.DaggerKompletionistKomponent
import com.marverenic.kompletionist.inject.KompletionistKomponent

class KompletionistApplication : Application() {

    companion object {
        lateinit var component: KompletionistKomponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerKompletionistKomponent
                .builder()
                .apply {
                    applicationModule(ApplicationModule(this@KompletionistApplication))
                }.build()
    }

}