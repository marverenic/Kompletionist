package com.marverenic.kompletionist.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.marverenic.kompletionist.BR
import com.marverenic.kompletionist.model.Task

class TaskViewModel : BaseObservable() {

    private lateinit var item: Task

    fun setTask(task: Task) {
        item = task
        notifyPropertyChanged(BR.name)
        notifyPropertyChanged(BR.complete)
    }

    @Bindable
    fun getName() = item.name

    @Bindable
    fun isComplete() = item.complete

}
