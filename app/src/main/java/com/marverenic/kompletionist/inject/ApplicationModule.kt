package com.marverenic.kompletionist.inject

import android.content.Context
import com.marverenic.kompletionist.data.LocalTodoDataStore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideTodoDataStore() = LocalTodoDataStore()

}