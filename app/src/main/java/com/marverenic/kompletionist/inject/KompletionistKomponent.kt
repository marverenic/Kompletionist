package com.marverenic.kompletionist.inject

import com.marverenic.kompletionist.ui.lists.AllListsActivity
import com.marverenic.kompletionist.ui.tasks.TodoListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface KompletionistKomponent {

    fun inject(activity: AllListsActivity)
    fun inject(activity: TodoListActivity)

}