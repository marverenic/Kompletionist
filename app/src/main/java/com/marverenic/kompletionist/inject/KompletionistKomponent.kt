package com.marverenic.kompletionist.inject

import com.marverenic.kompletionist.activity.AllListsActivity
import com.marverenic.kompletionist.activity.TodoListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface KompletionistKomponent {

    fun inject(activity: AllListsActivity)
    fun inject(activity: TodoListActivity)

}