package com.marverenic.kompletionist.inject

import com.marverenic.kompletionist.MainActivity
import dagger.Component

@Component(modules = arrayOf(ApplicationModule::class))
interface KompletionistKomponent {

    fun inject(activity: MainActivity)

}