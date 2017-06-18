package com.marverenic.kompletionist.viewmodel

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable
import com.marverenic.kompletionist.BR
import com.marverenic.kompletionist.activity.TodoListActivity
import com.marverenic.kompletionist.model.TodoList

class ListViewModel(val context: Context) : BaseObservable() {

    private lateinit var list: TodoList

    fun setList(todoList: TodoList) {
        list = todoList
        notifyPropertyChanged(BR.listName)
    }

    @Bindable
    fun getListName() = list.name

    fun onClickList() = context.startActivity(TodoListActivity.newIntent(context, list))

}