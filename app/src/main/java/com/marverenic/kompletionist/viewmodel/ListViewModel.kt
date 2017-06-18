package com.marverenic.kompletionist.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.marverenic.kompletionist.BR
import com.marverenic.kompletionist.model.TodoList

class ListViewModel : BaseObservable() {

    private lateinit var list: TodoList

    fun setList(todoList: TodoList) {
        list = todoList
        notifyPropertyChanged(BR.listName)
    }

    @Bindable
    fun getListName() = list.name

}